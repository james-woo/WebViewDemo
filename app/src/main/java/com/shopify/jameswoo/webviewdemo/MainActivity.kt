package com.shopify.jameswoo.webviewdemo

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_main.*
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 4. Set up toolbar
        setSupportActionBar(toolbar)

        // 2. Set up the webview and loadUrl
        webview.settings.javaScriptEnabled = true
        webview.loadUrl("file:///android_asset/index.html")

        // 6. Hook up javascript interface with the name "Android"
        webview.addJavascriptInterface(WebAppInterface(this), "Android")
    }

    // 5. Add the javascript interface
    inner class WebAppInterface(private var context: Context) {
        @JavascriptInterface
        fun showToast(toast: String) {
            Toast.makeText(context, toast, Toast.LENGTH_SHORT).show()
        }

        @JavascriptInterface
        fun setTitle(title: String) {
            toolbar.title = title
        }
    }
}
