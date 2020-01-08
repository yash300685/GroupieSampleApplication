package com.test.groupiesample

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TVApplication :Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TVApplication)
            modules(listOf(appMopdule, networkModule, fragmentModule))
        }
    }
}