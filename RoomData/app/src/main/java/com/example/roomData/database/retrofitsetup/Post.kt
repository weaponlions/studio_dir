package com.example.roomData.database.retrofitsetup

import androidx.room.PrimaryKey


data class Post(
    val body: String,
    @PrimaryKey
    val id: Int,
    val title: String,
    val userId: Int
)