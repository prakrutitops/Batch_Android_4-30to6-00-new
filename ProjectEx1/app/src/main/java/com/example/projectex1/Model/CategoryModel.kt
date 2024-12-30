package com.example.projectex1.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CategoryModel
{
    @Expose
    @SerializedName("id")
    var id = 0

    @Expose
    @SerializedName("name")
    var name: String? = null

    @Expose
    @SerializedName("url")
    var url: String? = null

    @Expose
    @SerializedName("description")
    var description: String? = null
    @Expose
    @SerializedName("price")
    var price: String? = null
}