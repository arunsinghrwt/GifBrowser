package com.arun.gifbrowser.Application.Network

import com.arun.gifbrowser.Application.Model.ViewModelGif
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 *Created by Arun singh rawat on 08-01-2021.
 *https://github.com/arunsinghrwt

 */

    var retrofitModule = module {
        single { returnProvideRetrofit() }
        single { getApi(get()) }
        factory { PbrBtn() }
       viewModel { ViewModelGif(get ()) }
    }






