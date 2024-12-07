package com.example.retrfotimageupload


import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part


interface Apiinterface
{
    @Multipart
    @POST("insert.php")
    fun uploaddata(
        @Part("pname") pname: RequestBody?,
        @Part("pprice") pprice: RequestBody?,
        @Part("pdesc") pdesc: RequestBody?,
        @Part("pstatus") pstatus: RequestBody?,
        @Part pimage: MultipartBody.Part
    ): Call<ResponseBody?>?
}