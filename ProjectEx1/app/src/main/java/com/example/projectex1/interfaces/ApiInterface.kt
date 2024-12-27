package com.example.classproject.interfaces


import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import tops.tech.batchproject_morning.RegisterModel


interface ApiInterface
{
    //Register
    @FormUrlEncoded
    @POST("user_signup.php")
    fun registerdetail(
        @Field("user_first_name") firstname: String?,
        @Field("user_last_name") lastname: String?,
        @Field("user_gender") gender:String?,
        @Field("user_email") email: String?,
        @Field("user_phone") mobile: String?,
        @Field("user_password") password: String?,
        ): Call<Void>

    //Login
    @FormUrlEncoded
    @POST("user_login.php")
    fun logindata(
        @Field("user_phone") mobile: String?,
        @Field("user_password") password: String?
    ): Call<RegisterModel>

}