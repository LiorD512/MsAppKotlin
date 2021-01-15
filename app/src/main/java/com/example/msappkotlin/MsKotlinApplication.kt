package com.example.msappkotlin

import android.app.Application
import com.example.msappkotlin.di.appModule
import com.example.msappkotlin.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MsKotlinApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }


    private fun setupKoin(){
        startKoin {
            androidContext(this@MsKotlinApplication)
            androidLogger()
            modules(appModule, networkModule)
        }
    }
}