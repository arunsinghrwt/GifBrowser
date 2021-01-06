package com.arun.gifbrowser.Application.Network

import com.arun.gifbrowser.Application.Model.GifModel
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {


   //get gif files
    @GET("/v1/gifs/trending")
    @Headers("Content-Type:application/json")
    open fun fetchPartialDetails(
       @Query("api_key") api_key: String?,
       @Query("limit") limit: Int?
   ): Flowable<GifModel>?


}