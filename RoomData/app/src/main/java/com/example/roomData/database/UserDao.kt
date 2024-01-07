package com.example.roomData.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecord(user: User)

    @Update
    suspend fun updateRecord(user: User)

    @Query("SELECT * FROM UserDetail")
    fun getAll(): LiveData<List<User>>
}
