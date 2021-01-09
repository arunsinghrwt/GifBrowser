package com.arun.gifbrowser.Application.Model




import android.util.Log
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.arun.gifbrowser.Application.Network.ApiInterface
import com.arun.gifbrowser.Application.Utility.Constants
import com.google.gson.GsonBuilder
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.ArrayList


/**
 *Created by Arun Singh Rawat on 09-01-2021.
 *https://github.com/arunsinghrwt

 */
class ViewModelGif( var apilist : ApiInterface ) : ViewModel(){

    var TAG = "ViewModelGif"
    var mediatorGifList = MediatorLiveData<ArrayList<GifList>>()
    fun getGifImageList(){
        var list = LiveDataReactiveStreams.fromPublisher(
                apilist.fetchDetails(Constants.API_KEY , "25","g")!!.onErrorReturn {
                    GifModel().apply {
                    }
                }.map {
                    return@map try {
                        Log.e("api_response","->> "+ GsonBuilder().create().toJson(it))
                        it.data
                    } catch (e: Exception) {

                        ArrayList<GifList>()
                    }
                }.subscribeOn(Schedulers.io())
        )

        mediatorGifList.addSource(list){
                  t ->
                  mediatorGifList.value = t
                  mediatorGifList.removeSource(list)

        } }
}