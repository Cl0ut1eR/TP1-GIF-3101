package ca.ulaval.ima.tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button

class WebsiteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_website)

        val url = intent.getStringExtra("url")

        val closeButton = findViewById<Button>(R.id.CloseBtn)
        val webView = findViewById<WebView>(R.id.MainWebView)

        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url.toString())

        closeButton.setOnClickListener(){
            finish()
        }
    }
}