package com.example.retrofitex

import retrofit2.Call
import retrofit2.http.GET

interface Apiinterface
{
    @GET("view.php")
    fun getdata() : Call<List<Model>>
}