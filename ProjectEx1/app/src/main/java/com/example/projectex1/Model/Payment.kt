package com.example.projectex1.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Payment
{
    @Expose
    @SerializedName("id")
    var id = 0

    @Expose
    @SerializedName("pname")
    var pname: String? = null


    @Expose
    @SerializedName("pprice")
    var pprice: String? = null

    @Expose
    @SerializedName("pdes")
    var pdes: String? = null

    @Expose
    @SerializedName("pimage")
    var pimage: String? = null


    @Expose
    @SerializedName("mobile")
    var mobile: String? = null
}