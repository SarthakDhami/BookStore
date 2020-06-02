package com.myapplication.bookstore.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.myapplication.bookstore.CommonClass.CommonClass
import com.myapplication.bookstore.Interface.OnClickListner
import com.myapplication.bookstore.R
import com.myapplication.bookstore.WebListView
import com.myapplication.bookstore.WebViewActivity

class BookLandscapeAdapter(var context: Context, var shortStory: List<String>, var imageIdList: Array<Int>,var itemList : OnClickListner) : RecyclerView.Adapter<BookLandscapeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_bookview, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return shortStory.size


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.img_book.setImageResource(imageIdList[position])
        holder.tv_bookNameList.setText(shortStory[position])

        holder.rel_bookList.setOnClickListener { view->
            itemList.setOnItemClick(view,position)


        }
    }

    class ViewHolder  (itemView: View) : RecyclerView.ViewHolder(itemView)  {
        var img_book = itemView.findViewById<ImageView>(R.id.img_bookList)
        var tv_bookNameList = itemView.findViewById<TextView>(R.id.tv_bookNameList)
        var rel_bookList = itemView.findViewById<RelativeLayout>(R.id.rel_bookList)
    }

}