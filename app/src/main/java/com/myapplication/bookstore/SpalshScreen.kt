package com.myapplication.bookstore

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SpalshScreen : AppCompatActivity() {
    var mHandler: Handler? = null
    var tv_version: TextView? = null
    var Spalshtime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh_screen)
    }
    override fun onResume() {
        super.onResume()
        Spalshtime = 1000
        mHandler = Handler()
        mHandler!!.postDelayed({

                Continue()
        }, Spalshtime)
    }

    private fun Continue() {
        val it = Intent(this@SpalshScreen, LoginPageActivity::class.java)
        startActivity(it)
        finish()
    }

}
