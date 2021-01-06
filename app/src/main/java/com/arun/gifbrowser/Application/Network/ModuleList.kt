package com.arun.gifbrowser.Application.Network

import org.koin.dsl.module

class ModuleList {
    var retrofitModule = module {
        single { returnProvideRetrofit() }
        single { getApi(get()) }
        factory { PbrBtn() }
    }



}