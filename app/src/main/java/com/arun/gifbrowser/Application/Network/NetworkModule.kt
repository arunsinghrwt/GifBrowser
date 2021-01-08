package com.arun.gifbrowser.Application.Network

import android.animation.ObjectAnimator
import androidx.multidex.BuildConfig
import com.arun.gifbrowser.Application.Utility.Constants
import com.arun.gifbrowser.Application.Utility.showProgressAnim
import com.arun.gifbrowser.R
import com.google.android.material.button.MaterialButton
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Modifier
/**
 *Created by Arun singh rawat on 08-01-2021.
 *https://github.com/arunsinghrwt

 */



     fun returnProvideRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE)
        }

        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor(logging)
        val gson = GsonBuilder()
            .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
            .serializeNulls()
            .setLenient()
            .create()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(
                httpClient.build()
            )
            .build()
    }

    fun getApi(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    class PbrBtn {
        var objectAnimator: ObjectAnimator? = null
        var mybtn: MaterialButton? = null
        fun init(btn: MaterialButton) {
            this.mybtn = btn
        }

        fun start() {
            objectAnimator?.cancel()
            mybtn?.setIconResource(R.drawable.animated_progress)
            this.objectAnimator = mybtn?.icon?.showProgressAnim()
        }

        fun cancel(defaulticon: Int = 0) {
            mybtn?.setIconResource(defaulticon)
            objectAnimator?.cancel()
        }
    }