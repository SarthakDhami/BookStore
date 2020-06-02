package com.myapplication.bookstore.Model

class data {

    var id : Int ? = 0
    var bookDrwable : Int ? = 0
    var bookName: String ? =null
    var bookAuthor : String ? = null
    var bookEstablish : String ? = null

    constructor() {}
    constructor(id: Int?, bookDrwable: Int?, bookName: String?, bookAuthor: String?, bookEstablish: String?) {
        this.id = id
        this.bookDrwable = bookDrwable
        this.bookName = bookName
        this.bookAuthor = bookAuthor
        this.bookEstablish = bookEstablish
    }

}