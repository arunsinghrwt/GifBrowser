package com.arun.gifbrowser.Application.Network

import com.arun.gifbrowser.Application.Model.GifModel
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
/**
 *Created by Arun singh rawat on 08-01-2021.
 *https://github.com/arunsinghrwt

 */

interface ApiInterface {
    //get gif files
    @GET("/v1/gifs/trending")
    @Headers("Content-Type:application/json")
    fun fetchDetails(
       @Query("api_key") api_key: String?,
       @Query("limit") limit: String?,   @Query("rating") rating: String?
   ): Flowable<GifModel>?


}