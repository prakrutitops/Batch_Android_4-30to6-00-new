package com.example.roomdbex

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class User
{

    @PrimaryKey(autoGenerate = true)
    var id=0

    @ColumnInfo(name = "username")
    var name=""

    @ColumnInfo(name = "useremail")
    var email=""

}