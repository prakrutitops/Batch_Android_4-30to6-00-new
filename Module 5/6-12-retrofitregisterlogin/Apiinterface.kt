package com.example.retrofitex


import com.example.retrofitregisterloginex.Model
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Apiinterface
{
    @FormUrlEncoded
    @POST("userinsert.php")
    fun registerdata
                (
                    @Field("name")  name:String,
                    @Field("surname")  surname:String,
                    @Field("email")  email:String,
                    @Field("password")  password:String
                ):Call<Void>

    @FormUrlEncoded
    @POST("userlogin.php")
    fun logindata(
        @Field("e1") email: String?,
        @Field("p1") password: String?
    ):Call<Model>


}