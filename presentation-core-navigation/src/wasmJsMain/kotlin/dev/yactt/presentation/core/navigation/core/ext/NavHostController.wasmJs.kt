package dev.yactt.presentation.core.navigation.core.ext

import androidx.navigation.NavHostController

actual fun NavHostController.openLink(url: String) {
    jsOpenLink(url, true)
}

@JsFun(
    """
    (url, newTab) => {
      // Use an <a> click to avoid some popup blockers.
      const a = document.createElement('a');
      a.href = url;
      if (newTab) {
        a.target = '_blank';
        a.rel = 'noopener noreferrer';
      }
      // Must be triggered by a user gesture to consistently bypass blockers.
      a.click();
    }
    """
)
private external fun jsOpenLink(url: String, newTab: Boolean): Unit