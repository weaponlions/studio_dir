package com.example.roomData

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomData.database.MainViewModel
import com.example.roomData.database.MainViewModelFactory
import com.example.roomData.database.User
import com.example.roomData.database.UserDatabase
import com.example.roomData.database.UserRepo
import com.example.roomData.database.retrofitsetup.PostApi
import com.example.roomData.database.retrofitsetup.RetrofitHelper
import com.example.roomData.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
//    private lateinit var database: UserDatabase
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val api = RetrofitHelper.getAPI().create(PostApi::class.java)
        GlobalScope.launch {
            val a = api.getPosts(1).body()
            if (a != null) Log.d("Userdata", a.toString())
        }

        val userDao = UserDatabase.getDatabase(applicationContext).userDao()
        val userRepo = UserRepo(userDao)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(userRepo))[MainViewModel::class.java]

        binding.insertBtn.setOnClickListener{
            mainViewModel.insertRecord(User("Ritik","Saini",8433480))
            Toast.makeText(this@MainActivity, "Created", Toast.LENGTH_SHORT)
        }

        binding.insertBtnTwo.setOnClickListener{
            mainViewModel.insertRecord(User("Vasu","Saini",111111))
            Toast.makeText(this@MainActivity, "Created", Toast.LENGTH_SHORT).show()
        }

        mainViewModel.getAll().observe(this, Observer {
            for (i in it){
                Log.d("Userdata", i.toString())
            }
        })

        binding.insertBtnThree.setOnClickListener{
           mainViewModel.updateRecord(User("Engineer","Wala",500000, id = 1))
            Toast.makeText(this@MainActivity, "Showing", Toast.LENGTH_SHORT).show()
        }
    }
}