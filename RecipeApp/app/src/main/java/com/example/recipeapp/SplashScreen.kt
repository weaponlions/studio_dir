package com.example.recipeapp

import android.R
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.recipeapp.databinding.ActivitySplashScreenBinding


class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val anim: Animation = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
        anim.repeatCount = Animation.INFINITE

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.logoText.startAnimation(anim)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            binding.logoText.clearAnimation()
            startActivity(intent)
            finish()
        }, 2000)
    }
}