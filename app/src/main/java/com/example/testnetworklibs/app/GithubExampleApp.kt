package com.example.testnetworklibs.app

import android.app.Application
import com.androidnetworking.AndroidNetworking
import com.example.testnetworklibs.di.networkModule
import com.example.testnetworklibs.di.viewModels
import com.jacksonandroidnetworking.JacksonParserFactory
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GithubExampleApp : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GithubExampleApp)
            modules(networkModule, viewModels)
        }
        AndroidNetworking.setParserFactory(JacksonParserFactory())
    }
}