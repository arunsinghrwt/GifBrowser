package com.arun.gifbrowser.Application.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

import com.example.gifbrowser.R


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_activty)
        mainActivity()
    }

    private fun mainActivity() {
        Handler(Looper.getMainLooper()).postDelayed({
            var intent  = Intent(this, MainActivity::class.java)
            startActivity(intent) },1000)
    }
}