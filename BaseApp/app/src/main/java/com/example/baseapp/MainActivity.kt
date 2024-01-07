package com.example.baseapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.baseapp.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: UserDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = UserDatabase.getDatabase(this)


        binding.buttonFirst.setOnClickListener {
            Toast.makeText(this, "Success Achievement is not easy!!!", Toast.LENGTH_SHORT).show()
        }

        binding.buttonSecond.setOnClickListener {
            binding.textView1.text = "Yes, I have Done"
            GlobalScope.launch{
                database.userDao().insertRecord(User(firstName = "Harsh", lastName = "Saini", mobile = 84334, className = "tenth"))
            }
        }

        binding.buttonThird.setOnClickListener {
            binding.textView1.text = "No, I have not Prepare"
        }

        binding.buttonSwitch.setOnClickListener {
            val intent = Intent(this@MainActivity, Contact::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "I am Preparing", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "I am Ready", Toast.LENGTH_SHORT).show()
    }

}