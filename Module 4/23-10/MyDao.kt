package com.example.roomdbex

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MyDao
{
    @Insert
    fun insertdata(user: User)

    @Query("select * from users")
    fun viewdata():MutableList<User>

    @Update
    fun updatedata(user: User)

    @Delete
    fun deletedata(user: User)

}