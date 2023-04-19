package cl.hamp.cursoandroid5

import android.graphics.Bitmap
import android.os.Bundle
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myWebView: WebView = findViewById(R.id.webview)

        val setting: WebSettings = myWebView.settings
        setting.javaScriptEnabled = true
        setting.domStorageEnabled = true

        myWebView.webChromeClient = object : WebChromeClient(){}
        myWebView.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return false;
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                // Obtener el agente de usuario actual
                val userAgent = setting.userAgentString

                // Imprimir el agente de usuario para depuración
                println("User Agent: $userAgent")
            }
        }

        myWebView.loadUrl("https://payments-psp-int.fpayapp.com/checkout-fpay-v2/cl/payment/643dab61f5604655a5f68357")
    }

}