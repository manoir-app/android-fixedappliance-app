package app.manoir.fixedappliances

import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient

class ManoirChromeWebClient : WebChromeClient() {
    override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
        return super.onConsoleMessage(consoleMessage)
    }
}