package com.example.roomData.database.retrofitsetup

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PostApi {

    @GET(value = "posts")
    suspend fun getPosts(@Query(value = "id") id: Int): Response<List<Post>>


//    suspend fun getPosts(@Query(value = "page") page: Int): Response<Post>
}