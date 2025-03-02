package com.lesa

import android.app.Application
import com.lesa.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CountriesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CountriesApp)
            androidLogger()
            modules(appModule)
        }
    }
}
