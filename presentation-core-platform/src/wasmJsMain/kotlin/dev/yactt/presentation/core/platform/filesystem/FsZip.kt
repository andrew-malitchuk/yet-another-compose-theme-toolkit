package dev.yactt.presentation.core.platform.filesystem

import kotlin.math.min

/**
 * Build and download a ZIP archive with nested folders and files.
 *
 * Example:
 * saveZipArchive(
 *   archiveName = "example.zip",
 *   structure = mapOf(
 *     "docs" to mapOf(
 *       "readme.txt" to "Hello!",
 *       "changelog.txt" to "v1.0.0"
 *     ),
 *     "images" to emptyMap<String, Any>(), // folder
 *     "root.txt" to "at root"
 *   )
 * )
 */
fun saveZipArchive(
    archiveName: String,
    structure: Map<String, Any>, // folder -> Map<String, Any>, file -> String (content)
) {
    val builder = ZipBuilder()
    addStructure(builder, "", structure)
    val bytes = builder.finish()
    val base64 = base64Encode(bytes)
    jsDownloadDataUrl(archiveName, "data:application/zip;base64,$base64")
}

private fun addStructure(
    builder: ZipBuilder,
    basePath: String,
    node: Map<String, Any>,
) {
    for ((name, value) in node) {
        val path = if (basePath.isEmpty()) name else "$basePath/$name"
        when (value) {
            is String -> builder.addFile(path, value.encodeToByteArray())
            is Map<*, *> -> {
                // Ensure directory entry exists
                builder.addDirectory(path)
                @Suppress("UNCHECKED_CAST")
                addStructure(builder, path, value as Map<String, Any>)
            }
            else -> error("Unsupported node under '$path': ${value?.let { it::class }}. Use String for files, Map for folders.")
        }
    }
}

// Minimal ZIP writer: store only (no compression), with central directory.
private class ZipBuilder {
    private val out = ByteSink()
    private val entries = mutableListOf<CentralEntry>()
    private val crc32 = Crc32()

    fun addDirectory(name: String) {
        val dirName = if (name.endsWith("/")) name else "$name/"
        val nameBytes = dirName.encodeToByteArray()

        val localHeaderOffset = out.size()
        writeLocalFileHeader(
            nameBytes = nameBytes,
            crc = 0,
            compSize = 0,
            uncompSize = 0,
            isDirectory = true,
        )
        // no data

        entries +=
            CentralEntry(
                nameBytes = nameBytes,
                crc = 0,
                compSize = 0,
                uncompSize = 0,
                localHeaderOffset = localHeaderOffset,
                isDirectory = true,
            )
    }

    fun addFile(
        path: String,
        data: ByteArray,
    ) {
        val nameBytes = path.encodeToByteArray()
        val localHeaderOffset = out.size()

        val crc = crc32.compute(data)
        val size = data.size

        writeLocalFileHeader(
            nameBytes = nameBytes,
            crc = crc,
            compSize = size,
            uncompSize = size,
            isDirectory = false,
        )
        out.write(data)

        entries +=
            CentralEntry(
                nameBytes = nameBytes,
                crc = crc,
                compSize = size,
                uncompSize = size,
                localHeaderOffset = localHeaderOffset,
                isDirectory = false,
            )
    }

    fun finish(): ByteArray {
        val centralStart = out.size()
        for (e in entries) writeCentralDirectoryEntry(e)
        val centralEnd = out.size()
        writeEndOfCentralDirectory(
            entriesCount = entries.size,
            centralDirSize = centralEnd - centralStart,
            centralDirOffset = centralStart,
        )
        return out.toByteArray()
    }

    private fun writeLocalFileHeader(
        nameBytes: ByteArray,
        crc: Int,
        compSize: Int,
        uncompSize: Int,
        isDirectory: Boolean,
    ) {
        // Local file header signature
        out.u32(0x04034b50)
        // version needed to extract (2.0)
        out.u16(20)
        // general purpose bit flag: set UTF-8 bit (11) to ensure file names are UTF-8
        out.u16(0x0800)
        // compression method: 0 = store
        out.u16(0)
        // file time/date (DOS) - set to 0
        out.u16(0)
        out.u16(0)
        // CRC-32
        out.u32(crc)
        // compressed size
        out.u32(compSize)
        // uncompressed size
        out.u32(uncompSize)
        // file name length
        out.u16(nameBytes.size)
        // extra field length
        out.u16(0)
        // file name
        out.write(nameBytes)
        // (no extra)
        // (file data follows; none for directories)
        if (isDirectory) {
            // No data
        }
    }

    private fun writeCentralDirectoryEntry(e: CentralEntry) {
        // Central directory file header signature
        out.u32(0x02014b50)
        // version made by (2.0) with "Unix" (3) << 8 | 20 -> 0x0314 (fine to keep 0x0014)
        out.u16(20)
        // version needed to extract
        out.u16(20)
        // general purpose bit flag: UTF-8
        out.u16(0x0800)
        // compression method
        out.u16(0)
        // file time/date
        out.u16(0)
        out.u16(0)
        // CRC-32
        out.u32(e.crc)
        // compressed size
        out.u32(e.compSize)
        // uncompressed size
        out.u32(e.uncompSize)
        // file name length
        out.u16(e.nameBytes.size)
        // extra length
        out.u16(0)
        // file comment length
        out.u16(0)
        // disk number start
        out.u16(0)
        // internal file attrs
        out.u16(0)
        // external file attrs (set directory attribute bit when needed)
        val externalAttrs = if (e.isDirectory) 0x10 else 0x00
        out.u32(externalAttrs)
        // relative offset of local header
        out.u32(e.localHeaderOffset)
        // file name
        out.write(e.nameBytes)
        // (no extra, no comment)
    }

    private fun writeEndOfCentralDirectory(
        entriesCount: Int,
        centralDirSize: Int,
        centralDirOffset: Int,
    ) {
        // End of central dir signature
        out.u32(0x06054b50)
        // number of this disk
        out.u16(0)
        // number of the disk with the start of the central directory
        out.u16(0)
        // total number of entries in the central dir on this disk
        out.u16(entriesCount)
        // total number of entries in the central dir
        out.u16(entriesCount)
        // size of the central directory
        out.u32(centralDirSize)
        // offset of start of central directory
        out.u32(centralDirOffset)
        // .ZIP file comment length
        out.u16(0)
        // (no comment)
    }

    private data class CentralEntry(
        val nameBytes: ByteArray,
        val crc: Int,
        val compSize: Int,
        val uncompSize: Int,
        val localHeaderOffset: Int,
        val isDirectory: Boolean,
    )
}

// Little-endian byte sink
private class ByteSink {
    private var buf = ByteArray(1024)
    private var len = 0

    fun size(): Int = len

    fun toByteArray(): ByteArray = buf.copyOf(len)

    fun write(b: ByteArray) {
        ensure(len + b.size)
        b.copyInto(buf, len, 0, b.size)
        len += b.size
    }

    fun u16(v: Int) {
        ensure(len + 2)
        buf[len++] = (v and 0xFF).toByte()
        buf[len++] = ((v ushr 8) and 0xFF).toByte()
    }

    fun u32(v: Int) {
        ensure(len + 4)
        buf[len++] = (v and 0xFF).toByte()
        buf[len++] = ((v ushr 8) and 0xFF).toByte()
        buf[len++] = ((v ushr 16) and 0xFF).toByte()
        buf[len++] = ((v ushr 24) and 0xFF).toByte()
    }

    private fun ensure(capacity: Int) {
        if (capacity <= buf.size) return
        var n = buf.size
        while (n < capacity) n = n + min(n, 1_048_576) // grow geometrically, cap chunk
        buf = buf.copyOf(n)
    }
}

// CRC-32 (IEEE 802.3) polynomial 0xEDB88320
private class Crc32 {
    private val table: IntArray =
        IntArray(256).also { t ->
            for (i in 0 until 256) {
                var c = i
                repeat(8) {
                    c = if ((c and 1) != 0) (c ushr 1) xor 0xEDB88320.toInt() else (c ushr 1)
                }
                t[i] = c
            }
        }

    fun compute(data: ByteArray): Int {
        var c = -1
        for (b in data) {
            c = table[(c xor (b.toInt() and 0xFF)) and 0xFF] xor (c ushr 8)
        }
        return c.inv()
    }
}

// Base64 (URL-safe not required; use standard)
private fun base64Encode(bytes: ByteArray): String {
    val table = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
    val out = StringBuilder((bytes.size * 4 + 2) / 3)
    var i = 0
    while (i < bytes.size) {
        val b0 = bytes[i++].toInt() and 0xFF
        val b1 = if (i < bytes.size) bytes[i++].toInt() and 0xFF else -1
        val b2 = if (i < bytes.size) bytes[i++].toInt() and 0xFF else -1

        val triplet = (b0 shl 16) or ((if (b1 >= 0) b1 else 0) shl 8) or (if (b2 >= 0) b2 else 0)

        out.append(table[(triplet ushr 18) and 0x3F])
        out.append(table[(triplet ushr 12) and 0x3F])
        out.append(if (b1 >= 0) table[(triplet ushr 6) and 0x3F] else '=')
        out.append(if (b2 >= 0) table[triplet and 0x3F] else '=')
    }
    return out.toString()
}

// Single safe JS bridge: download a data URL
@JsFun(
    """
    (name, dataUrl) => {
      const a = document.createElement('a');
      a.href = dataUrl;
      a.download = name;
      a.click();
    }
    """,
)
private external fun jsDownloadDataUrl(
    name: String,
    dataUrl: String,
): Unit
