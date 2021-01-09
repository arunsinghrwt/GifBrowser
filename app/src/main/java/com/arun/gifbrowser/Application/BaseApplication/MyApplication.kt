package com.arun.gifbrowser.Application.BaseApplication

import androidx.multidex.MultiDexApplication
import com.arun.gifbrowser.Application.Network.retrofitModule

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
/**
 *Created by Arun singh rawat on 08-01-2021.
 *https://github.com/arunsinghrwt

 */

class MyApplication : MultiDexApplication() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(applicationContext)
            koin.loadModules(listOf(retrofitModule))
            koin.createRootScope()



        }
    }

}