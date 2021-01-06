package com.arun.gifbrowser.Application.BaseApplication

import androidx.multidex.MultiDexApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.Koin
import org.koin.core.context.startKoin

class MyApplication : MultiDexApplication() {


    override fun onCreate() {
        super.onCreate()

        startKoin {

                     androidContext(applicationContext)

            modules()

        }
    }

}