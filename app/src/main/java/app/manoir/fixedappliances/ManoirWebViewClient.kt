package app.manoir.fixedappliances

import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class ManoirWebViewClient : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
        view.loadUrl(request.url.toString())
        return false
    }
}