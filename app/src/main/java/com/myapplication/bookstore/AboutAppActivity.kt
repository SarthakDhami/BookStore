package com.myapplication.bookstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.custom_actionbar.*

class AboutAppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_app)
        tv_userName.visibility = View.GONE
        tv_toolbar_title.setText("About App")
        rel_more.visibility = View.GONE
        rel_back.setOnClickListener { view->
            finish()
        }
    }
}
