package com.example.baseapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun insertRecord(user: User)

    @Delete
    suspend fun deleteRecord(user: User)

    @Query("Select * from UserDetail order by firstName ASC")
    fun getDataByFirstName(): Flow<List<User>>

    @Query("Select * from UserDetail order by lastName ASC")
    fun getDataByLastName(): Flow<List<User>>

}