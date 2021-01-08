package com.arun.gifbrowser.Application.Network

import org.koin.dsl.module

/**
 *Created by Arun singh rawat on 08-01-2021.
 *https://github.com/arunsinghrwt

 */

class ModuleList {
    var retrofitModule = module {
        single { returnProvideRetrofit() }
        single { getApi(get()) }
        factory { PbrBtn() }
    }



}