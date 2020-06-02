package com.myapplication.bookstore

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.*
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_web_list_view.*
import kotlinx.android.synthetic.main.activity_web_view.*
import kotlinx.android.synthetic.main.custom_actionbar.*

class WebListView : AppCompatActivity() {
    private lateinit var urlList : List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_list_view)
        var position = intent.getIntExtra("POSITIONLIIST", 0)
        var List =intent?.getStringExtra("LISTNAME")
        tv_userName.visibility = View.GONE
        rel_more.visibility = View.GONE
        rel_back.setOnClickListener { view->
            finish()
        }
        if (List == "popularBook"){
            urlList = resources.getStringArray(R.array.urlPopularBook).toList()

        }
        else if (List == "genralBook"){
            urlList = resources.getStringArray(R.array.urlgenralBook).toList()

        }
        else if (List == "popularshortstory"){
            urlList = resources.getStringArray(R.array.urlPopularShort).toList()

        }
        else if (List == "novel"){
            urlList = resources.getStringArray(R.array.urlNovel).toList()

        }
        else if (List == "shortStory"){
            urlList = resources.getStringArray(R.array.urlShortStory).toList()
        }

        web_privacyList?.setWebChromeClient(object : WebChromeClient() {
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onProgressChanged(webView: WebView, progress: Int) {
                if (progress < 100 && progress_policyList.getVisibility() == ProgressBar.GONE) {
                    progress_policyList.setVisibility(View.VISIBLE)
                } else {
                    progress_policyList.setVisibility(View.GONE)
                }
            }
        })


        var url =urlList[position]
//        var url = "https://www.gutenberg.org/files/48320/48320-h/48320-h.htm"
        web_privacyList.loadUrl(url)
        web_privacyList.setInitialScale(2);
        web_privacyList.getSettings().setLoadWithOverviewMode(true)
        web_privacyList.getSettings().setUseWideViewPort(true)
        web_privacyList.getSettings().setJavaScriptEnabled(true)
        web_privacyList.getSettings().setBuiltInZoomControls(true)

        web_privacyList.setWebViewClient(object : WebViewClient() {
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
