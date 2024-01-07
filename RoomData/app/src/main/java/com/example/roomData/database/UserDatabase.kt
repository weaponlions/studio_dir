package com.example.roomData.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
public abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object{

        @Volatile
        private var INSTANCE : UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "USER_DB").build()
                }
            }
            return INSTANCE!!
        }
    }
}