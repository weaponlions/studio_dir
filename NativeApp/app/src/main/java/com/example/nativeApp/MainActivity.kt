package com.example.nativeApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import com.example.nativeApp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = stringFromJNI()
    }

    external fun stringFromJNI(): String

//    fun startMain(object obj) {
//        Handler hand =
//    }

    companion object {
        // Used to load the 'nativeApp' library on application startup.
        init {
            System.loadLibrary("nativeApp")
        }
    }
}