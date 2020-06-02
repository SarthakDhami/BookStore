package com.myapplication.bookstore

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.bookstore.Adapter.BookListAdapter
import com.myapplication.bookstore.Adapter.PopularListAdapter
import com.myapplication.bookstore.Adapter.PopularShortAdapter
import com.myapplication.bookstore.CommonClass.CommonClass
import com.myapplication.bookstore.Interface.OnClickListner
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_actionbar.*

class MainActivity : AppCompatActivity() {
    private lateinit var mSP : SP

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mSP = SP(this)
        rel_back.visibility =View.GONE
        var emailFromIntent = mSP?.getString(this,SP_Keys.USERNAME,"s")
        tv_userName.text = "Hi...$emailFromIntent"

        var ImageIdList = CommonClass.getDrawableList()
        var ImagePopList = CommonClass.getPopulatShortStory()
        var PopularBookName = resources.getStringArray(R.array.popularBook).toList()
        var BookTypeList = resources.getStringArray(R.array.booktypes)
        var PopularShort = resources.getStringArray(R.array.popularshortstory).toList()

        r1_List.apply {
            this?.layoutManager = LinearLayoutManager(this@MainActivity,RecyclerView.HORIZONTAL,false)
        }
        var adapterList =  BookListAdapter(this,BookTypeList)
        r1_List.adapter =adapterList
        adapterList.notifyDataSetChanged()

        r1_popularBook.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            this?.layoutManager = LinearLayoutManager(this@MainActivity,RecyclerView.HORIZONTAL,false)
        }
        r1_popularshort.apply {
            this?.layoutManager = LinearLayoutManager(this@MainActivity,RecyclerView.HORIZONTAL,false)

        }
        var adapterPopShort = PopularShortAdapter(this,ImagePopList,PopularShort)
        r1_popularshort.adapter =adapterPopShort

        var adapter = PopularListAdapter(this,ImageIdList,PopularBookName,object : OnClickListner{
            override fun setOnItemClick(view: View, position: Int) {


            }
        })
        r1_popularBook.adapter =adapter
        adapter.notifyDataSetChanged()


        rel_more.setOnClickListener { view->
            popup(view)
        }

    }

    private fun popup(v: View?) {
        val popup = PopupMenu(this@MainActivity, v)
        popup.menuInflater.inflate(R.menu.menu, popup.menu)
        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {

                R.id.logout -> {
                    mSP?.setString(this,SP_Keys.USERNAME,"s")
                    mSP?.setString(this,SP_Keys.PASSWORD,"s")
                    val it1 = Intent(this@MainActivity, LoginPageActivity::class.java)
                    startActivity(it1)
                    finish()
                }
            }
            true
        }
        popup.show()

    }
}
