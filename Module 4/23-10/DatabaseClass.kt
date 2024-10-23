package com.example.roomdbex

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class DatabaseClass :RoomDatabase()
{
    abstract fun daoClass(): MyDao
}