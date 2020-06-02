package com.myapplication.bookstore.Interface

import android.view.View

interface OnClickListner {
    fun setOnItemClick(view: View, position: Int)
}