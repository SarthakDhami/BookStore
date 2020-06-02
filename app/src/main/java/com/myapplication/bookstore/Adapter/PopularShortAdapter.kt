package com.myapplication.bookstore.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.myapplication.bookstore.CommonClass.CommonClass
import com.myapplication.bookstore.R
import com.myapplication.bookstore.WebViewActivity

class PopularShortAdapter(
    var context: Context,
    var imagePopList: Array<Int>,
    var popularShort: List<String>
) : RecyclerView.Adapter<PopularShortAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.booklayout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return imagePopList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_PopBookName.setText(popularShort[position])
        holder.img_book.setImageResource(imagePopList[position])

        holder.img_book.setOnClickListener { view ->

            if (CommonClass.check_internet(context)) {
                val it = Intent(context, WebViewActivity::class.java)
                it.putExtra("POSITION", (position+10))
                context.startActivity(it)
            } else {
                Snackbar.make(holder.itemView, R.string.NOInternet, Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_PopBookName = itemView.findViewById<TextView>(R.id.tv_bookTitle)
        var img_book = itemView.findViewById<ImageView>(R.id.img_book)

    }
}