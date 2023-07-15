package com.example.productinfoapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context:Context):SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {
    companion object{
        val DATABASE_NAME="product.db"
        val DATABASE_VERSION=1
    }

    override fun onCreate(db: SQLiteDatabase) {
        //this is where u create a table
      db.execSQL("""
          CREATE TABLE product(
          product_id INTEGER PRIMARY KEY AUTOINCREMENT,
          product_name TEXT,
          product_description TEXT
          )
      """.trimIndent())
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //this is where the version is being updated
        //dropping TABLES
        db.execSQL("DROP TABLE  IF EXISTS product")
        onCreate(db)
    }

    //insert product
    fun insertProduct(product: Product){
        val db = writableDatabase
        val sql= "INSERT INTO product(product_name,product_description) values(?,?)"
        val args= arrayOf(product.name,product.description)
        db.execSQL(sql,args)
    }
    //get all product
    fun getAllProducts():MutableList<Product>{
        val db= readableDatabase
        val cursor =db.rawQuery("SELECT * FROM product",null)
        val productList= mutableListOf<Product>()

        while (cursor.moveToNext()){
            val id =cursor.getInt(0)
            val name =cursor.getString(1)
            val description =cursor.getString(2)

            var newProduct =Product(id,name, description)
            productList.add(newProduct)
        }
        //always close cursor
        cursor.close()
        return productList

    }
}