package com.example.sqlitedbex

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(var context:Context) : SQLiteOpenHelper(context,DB_NAME,null, DB_VERSION)
{
    companion object
    {
        var DB_NAME="tops.db"
        var TABLE_NAME="info"
        var DB_VERSION=1
        var ID="id"
        var NAME="name"
        var NUMBER="num"
        var PASSWORD="pass"
    }


    override fun onCreate(db: SQLiteDatabase?)
    {
       var query ="CREATE TABLE "+ TABLE_NAME +"("+ ID +"  INTEGER PRIMARY KEY, "+ NAME +" text ,"+ NUMBER +" text ,"+ PASSWORD +" text "+")"
       db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    {
       var upquery="DROP TABLE IF EXIST "+ TABLE_NAME
       db!!.execSQL(upquery)
       onCreate(db)
    }

    fun insertdata(m:Model):Long
    {
        var db:SQLiteDatabase = writableDatabase
        var values = ContentValues()
        //get detail
        values.put(NAME,m.name)
        values.put(NUMBER,m.num)
        values.put(PASSWORD,m.pass)
        var id =db.insert(TABLE_NAME,ID,values)
        return id

    }


}