package com.example.baseapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserDetail")
data class User(
    val firstName: String,
    val lastName: String,
    val mobile: Long,
    val className: String,
    @PrimaryKey(autoGenerate = true, )
    val id: Int? = 0,
)
