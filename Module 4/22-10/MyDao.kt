package com.example.roomdbex

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MyDao
{
    @Insert
    fun insertdata(user: User)

    @Query("select * from users")
    fun viewdata():MutableList<User>

}