package com.waysnpaths.github_api_test

import android.app.Application
import com.waysnpaths.github_api_test.ui.serviceLocator.appModule
import com.waysnpaths.github_api_test.ui.serviceLocator.dbModule
import com.waysnpaths.github_api_test.ui.serviceLocator.remoteModule
import com.waysnpaths.github_api_test.ui.serviceLocator.viewModelModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber

// todo the app should be unit tested, but it already took too much time
class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
        startKoin(this, listOf(appModule, viewModelModule, remoteModule, dbModule))
    }
}