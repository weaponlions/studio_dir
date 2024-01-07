package com.example.roomData.database.retrofitsetup

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    val BASE_URl = "https://jsonplaceholder.typicode.com/"

    fun getAPI(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URl).addConverterFactory(GsonConverterFactory.create()).build()
    }
}