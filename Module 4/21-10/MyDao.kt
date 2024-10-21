package com.example.roomdbex

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert

@Dao
interface MyDao
{
    @Insert
    fun insertdata(user: User)

}