package com.example.roomData.database

import androidx.lifecycle.LiveData

class UserRepo(private val userDao: UserDao) {

    fun getAll(): LiveData<List<User>> {
        return userDao.getAll()
    }

    suspend fun insertRecord(user: User){
        userDao.insertRecord(user)
    }

    suspend fun updateRecord(user: User){
        userDao.insertRecord(user)
    }

}