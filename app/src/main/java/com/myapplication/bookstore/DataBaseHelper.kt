package com.myapplication.bookstore

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import com.myapplication.bookstore.Model.data
import com.myapplication.bookstore.Model.dataLogin

class DataBaseHelper : SQLiteOpenHelper {

    var context: Context? = null

    constructor(context: Context) : super(context, DATABASE_NAME, null, DATABASE_VERSION) {
        this.context = context
    }

    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "BookStore.db"
        val TABLE_NAME_LOGIN = "LoginPage"
        val COLUMN_ID = "_id"
        val USERNAME = "userName"
        val PASSWORD = "password"
        val EXTRA = "extra"

    }
    private val SQL_CREATE_ENTRIES =
        "CREATE TABLE $TABLE_NAME_LOGIN (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$USERNAME TEXT," +
                "$PASSWORD TEXT," +
                "$EXTRA TEXT)"

    private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $TABLE_NAME_LOGIN"



    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE_ENTRIES)

    }

    fun getAllUser(): List<dataLogin> {

        // array of columns to fetch
        val columns = arrayOf(COLUMN_ID, USERNAME, PASSWORD, EXTRA)

        // sorting orders
        val userList = ArrayList<dataLogin>()

        val db = this.readableDatabase

        // query the user table
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("select * from $TABLE_NAME_LOGIN", null)
        } catch (e: SQLiteException) {
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList<dataLogin>()
        }

        cursor?.moveToFirst()

        while (!cursor?.isAfterLast!!) {
            val obj = dataLogin(cursor.getInt(0),
                cursor.getString(cursor.getColumnIndex(USERNAME)),
                cursor.getString(cursor.getColumnIndex(PASSWORD)),
                cursor.getString(cursor.getColumnIndex(EXTRA)))

            userList.add(obj)

            cursor.moveToNext()

        }
        cursor.close()

        return userList
    }

    fun addUser(user: dataLogin) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(USERNAME, user.username)
        values.put(PASSWORD, user.passwword)
        values.put(EXTRA, user.extra)

        // Inserting Row
        db.insert(TABLE_NAME_LOGIN, null, values)
        db.close()
    }

    fun checkUser(email: String): Boolean {

        // array of columns to fetch
        val columns = arrayOf(COLUMN_ID)
        val db = this.readableDatabase

        // selection criteria
        val selection = "$USERNAME = ?"

        // selection argument
        val selectionArgs = arrayOf(email)

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        val cursor = db.query(
            TABLE_NAME_LOGIN, //Table to query
            columns,        //columns to return
            selection,      //columns for the WHERE clause
            selectionArgs,  //The values for the WHERE clause
            null,  //group the rows
            null,   //filter by row groups
            null)  //The sort order


        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if (cursorCount > 0) {
            return true
        }

        return false
    }

    fun checkUser(email: String, password: String): Boolean {

        // array of columns to fetch
        val columns = arrayOf(COLUMN_ID)

        val db = this.readableDatabase

        // selection criteria
        val selection = "$USERNAME = ? AND $PASSWORD = ?"

        // selection arguments
        val selectionArgs = arrayOf(email, password)

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        val cursor = db.query(
            TABLE_NAME_LOGIN, //Table to query
            columns, //columns to return
            selection, //columns for the WHERE clause
            selectionArgs, //The values for the WHERE clause
            null,  //group the rows
            null, //filter by row groups
            null) //The sort order

        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if (cursorCount > 0)
            return true

        return false

    }

    fun updateUser(user: dataLogin) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(USERNAME, user.username)
        values.put(PASSWORD, user.passwword)
        values.put(EXTRA, user.extra)

        // updating row
        db.update(
            TABLE_NAME_LOGIN, values, "$COLUMN_ID = ?",
            arrayOf(user.id.toString()))
        db.close()
    }
    /**
     * This method is to delete user record
     *
     * @param user
     */
    fun deleteUser(user: dataLogin) {

        val db = this.writableDatabase
        // delete user record by id
        db.delete(
            TABLE_NAME_LOGIN, "$COLUMN_ID = ?",
            arrayOf(user.id.toString()))
        db.close()
    }
}