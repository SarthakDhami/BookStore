package com.myapplication.bookstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.myapplication.bookstore.Adapter.BookLandscapeAdapter
import com.myapplication.bookstore.CommonClass.CommonClass
import com.myapplication.bookstore.Interface.OnClickListner
import kotlinx.android.synthetic.main.activity_book_list.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_actionbar.*

class BookListActivity : AppCompatActivity() {
    private lateinit var shortStory: List<String>
    private lateinit var ImageIdList: Array<Int>
    private lateinit var List :String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)
        tv_userName.visibility = View.GONE
        rel_more.visibility = View.GONE
        rel_back.setOnClickListener { view ->
            finish()
        }
        val position = intent.getIntExtra("POSITIONLIST", 0)

        if (position == 0) {
            shortStory = resources.getStringArray(R.array.shortStory).toList()
            ImageIdList = CommonClass.getShortstory()
            List = "shortStory"
        } else if (position == 1) {
            shortStory = resources.getStringArray(R.array.novel).toList()
            ImageIdList = CommonClass.getNovel()
            List = "novel"

        } else if (position == 2) {
            shortStory = resources.getStringArray(R.array.popularshortstory).toList()
            ImageIdList = CommonClass.getPopulatShortStory()
            List = "popularshortstory"
        } else if (position == 3) {
            shortStory = resources.getStringArray(R.array.popularBook).toList()
            ImageIdList = CommonClass.getDrawableList()
            List = "popularBook"
        } else if (position == 4) {
            shortStory = resources.getStringArray(R.array.genralBook).toList()
            ImageIdList = CommonClass.getGenralBook()
            List = "genralBook"
        }
        r1_listHori.apply {
            this?.layoutManager = LinearLayoutManager(this@BookListActivity)
        }
        var adapter = BookLandscapeAdapter(this, shortStory, ImageIdList, object : OnClickListner {
            override fun setOnItemClick(view: View, position: Int) {
                if (CommonClass.check_internet(this@BookListActivity)) {
                    val it = Intent(this@BookListActivity, WebListView::class.java)
                    it.putExtra("POSITIONLIIST", position)
                    it.putExtra("LISTNAME",List)
                    this@BookListActivity.startActivity(it)
                } else {
                    Snackbar.make(r1_listHori, R.string.NOInternet, Snackbar.LENGTH_SHORT).show()
                }
            }
        })
        r1_listHori.adapter = adapter

    }
}
