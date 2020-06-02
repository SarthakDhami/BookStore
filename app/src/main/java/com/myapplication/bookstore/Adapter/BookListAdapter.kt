package com.myapplication.bookstore.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.bookstore.BookListActivity
import com.myapplication.bookstore.R
import com.myapplication.bookstore.WebViewActivity

class BookListAdapter(var context: Context, var bookTypeList: Array<String>) : RecyclerView.Adapter<BookListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.book_type, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return bookTypeList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_bookList.setText(bookTypeList[position])
        holder.tv_bookList.setOnClickListener { view->
            val it = Intent(context, BookListActivity::class.java)
            it.putExtra("POSITIONLIST", position)
            context.startActivity(it)
        }
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView)  {
        var tv_bookList =itemView.findViewById<TextView>(R.id.tv_bookList)

    }


}