package com.example.roomData.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val userRepo: UserRepo): ViewModel() {

    fun getAll(): LiveData<List<User>> {
        return userRepo.getAll()
    }

    fun insertRecord(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepo.insertRecord(user)
        }
    }

    fun updateRecord(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepo.updateRecord(user)
        }
    }

}