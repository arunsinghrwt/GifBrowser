package com.arun.gifbrowser.Application.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

import com.arun.gifbrowser.R
/**
 *Created by Arun singh rawat on 08-01-2021.
 *https://github.com/arunsinghrwt

 */



class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_activty)
        mainActivity()
    }

    private fun mainActivity() {
        Handler(Looper.getMainLooper()).postDelayed({
            var intent  = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish() },1000)
    }
}