package dev.yactt.presentation.core.ui.source.widget.customsnackbar

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Stable
class ShackBarState {
    private var job: Job? = null
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    var duration = 2_000L
    var textAlignment by mutableStateOf(TextAlign.Start)
    var contentAlignment by mutableStateOf(Alignment.TopCenter)

    var isVisible by mutableStateOf(false)
        private set

    var message: String by mutableStateOf("")
        private set

    private fun show(message: String) {
        this.message = message
        isVisible = true
    }

    fun dismiss() {
        isVisible = false
    }

    fun showSnackBar(message: String) {
        job?.cancel()
        show(message)
        job =
            coroutineScope.launch {
                delay(duration)
                dismiss()
            }
    }
}
