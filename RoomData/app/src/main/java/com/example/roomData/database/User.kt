package com.example.roomData.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserDetail")

data class User(
    val firstName: String,
    val lastName: String,
    val mobile: Long,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)

//@ColumnInfo(name = "mobile_number") val mobile: Long,
//@ColumnInfo(name = "first_name") val firstName: String?,
//@ColumnInfo(name = "last_name") val lastName: String?,
//@PrimaryKey(autoGenerate = true) val id: Int?,