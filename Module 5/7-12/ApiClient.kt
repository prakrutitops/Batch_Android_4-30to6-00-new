package com.example.retrfotimageupload

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient
{
    companion object
    {
        var BASE_URL="https://prakrutitech.buzz/Rahul/"
        lateinit var retrofit: Retrofit

        fun getapiclient() : Retrofit
        {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }

    }
}