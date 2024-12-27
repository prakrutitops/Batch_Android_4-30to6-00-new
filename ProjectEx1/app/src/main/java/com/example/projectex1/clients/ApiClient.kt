package com.example.classproject.clients

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient
{
    companion object {

        var BASE_URL="https://prakrutitech.buzz/AndroidAPI/"
        var retrofit: Retrofit? = null
        fun getapiclient(): Retrofit? {

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return  retrofit
        }
    }
}