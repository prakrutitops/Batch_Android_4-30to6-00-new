package com.example.rmom

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class Model : RealmObject()
{
    @PrimaryKey
    var id=0
    var name=""
    var num=""

}