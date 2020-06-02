package com.myapplication.bookstore.CommonClass

import android.content.Context
import android.net.ConnectivityManager
import com.myapplication.bookstore.R

object CommonClass {

    fun getDrawableList(): Array<Int> {

        var ImageIdList = arrayOf<Int>(R.drawable.sherlock,R.drawable.aliceinwonderland,R.drawable.romeoandjuliet,R.drawable.thealterofthedead,R.drawable.prideandprejudice,R.drawable.twelveyearofslave)
        return ImageIdList
    }
    fun getShortstory(): Array<Int>{
        var ShortStory = arrayOf<Int>(R.drawable.scandalinbohemia,R.drawable.redheadedleague,R.drawable.caseofidentity,R.drawable.boscombevalleymystrey,R.drawable.fiveorangepip,
        R.drawable.manwiththetwistedlip,R.drawable.theadventureofthebluecarbuncle,R.drawable.theadventureofthespeckledband,R.drawable.theadventureoftheengineersthumb,
        R.drawable.thenoobelbachelor,R.drawable.berylcoronet,R.drawable.cooperbeeches)
        return ShortStory
    }

    fun getGenralBook(): Array<Int>{
        var PopularShortList = arrayOf<Int>(R.drawable.thealterofthedead,R.drawable.prideandprejudice,R.drawable.twelveyearofslave,R.drawable.memorisofsherlock,R.drawable.returnofsherlockholmes,R.drawable.casebookofsherlockholmes,R.drawable.completesherlockholmes)
        return PopularShortList
    }
    fun getNovel(): Array<Int>{
        var Novel = arrayOf<Int>(R.drawable.nostudyinscarlet,R.drawable.nosignoffour,R.drawable.nothehoundofthebaskervilles,R.drawable.nothevalleyoffear)
        return Novel
    }

    fun getPopulatShortStory(): Array<Int>{
        var Novel = arrayOf<Int>(R.drawable.theadventureofthebluecarbuncle,R.drawable.theadventureofthespeckledband,R.drawable.theadventureoftheengineersthumb,
            R.drawable.thenoobelbachelor,R.drawable.berylcoronet,R.drawable.cooperbeeches)
        return Novel
    }


    fun check_internet(context: Context?): Boolean {
        return if (context != null) {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetworkInfo
            netInfo != null && netInfo.isConnectedOrConnecting
        } else false
    }

}