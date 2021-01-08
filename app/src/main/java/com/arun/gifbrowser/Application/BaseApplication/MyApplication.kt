package com.arun.gifbrowser.Application.BaseApplication

import androidx.multidex.MultiDexApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
/**
 *Created by Arun singh rawat on 08-01-2021.
 *https://github.com/arunsinghrwt

 */

class MyApplication : MultiDexApplication() {


    override fun onCreate() {
        super.onCreate()

        startKoin {

                     androidContext(applicationContext)

            modules()

        }
    }

}