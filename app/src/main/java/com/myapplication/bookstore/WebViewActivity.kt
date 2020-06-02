package com.myapplication.bookstore

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.*
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_web_view.*
import kotlinx.android.synthetic.main.custom_actionbar.*

class WebViewActivity : AppCompatActivity() {
    private lateinit var urlList : List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        var position = intent.getIntExtra("POSITION", 0)
        tv_userName.visibility = View.GONE
        rel_more.visibility = View.GONE
        rel_back.setOnClickListener { view->
            finish()
        }

//        Toast.makeText(this, "" + position, Toast.LENGTH_SHORT).show()

        web_privacy?.setWebChromeClient(object : WebChromeClient() {
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onProgressChanged(webView: WebView, progress: Int) {
                if (progress < 100 && progress_policy.getVisibility() == ProgressBar.GONE) {
                    progress_policy.setVisibility(View.VISIBLE)
                } else {
                    progress_policy.setVisibility(View.GONE)
                }
            }
        })

        if (position < 10){
            urlList = resources.getStringArray(R.array.urlPopularBook).toList()

        }else if (position >= 10){
            position -= 10;
            urlList = resources.getStringArray(R.array.urlPopularShort).toList()

        }


        var url =urlList[position]
//        var url = "https://www.gutenberg.org/files/48320/48320-h/48320-h.htm"
        web_privacy.loadUrl(url)
        web_privacy.setInitialScale(2);
        web_privacy.getSettings().setLoadWithOverviewMode(true)
        web_privacy.getSettings().setUseWideViewPort(true)
        web_privacy.getSettings().setJavaScriptEnabled(true)
        web_privacy.getSettings().setBuiltInZoomControls(true)

        web_privacy.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }
            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                super.onReceivedError(view, request, error)
//                Toast.makeText(this@WebViewActivity, "Failed" , Toast.LENGTH_SHORT).show()

            }
        })

    }
}
