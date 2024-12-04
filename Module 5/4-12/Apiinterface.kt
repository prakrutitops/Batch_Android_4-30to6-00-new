package com.example.retrofitex

import com.example.retrofitcrudex1.Model
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Apiinterface
{
    @FormUrlEncoded
    @POST("userinsert.php")
    fun insertdata
                (
                    @Field("name") name:String,
                    @Field("surname")  surname:String,
                    @Field("email")  email:String,
                    @Field("password")  password:String
                ):Call<Void>

    @GET("userview.php")
    fun getdata() : Call<List<Model>>

    @FormUrlEncoded
    @POST("userupdate.php")
    fun updatedata
                (
        @Field("id") id:Int,
        @Field("name") name:String,
        @Field("surname")  surname:String,
        @Field("email")  email:String,
        @Field("password")  password:String
    ):Call<Void>

    @FormUrlEncoded
    @POST("userdelete.php")
    fun deletedata(@Field("id") id: Int): Call<Void?>?
}