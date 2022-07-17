package com.waysnpaths.github

import androidx.multidex.MultiDexApplication
import com.waysnpaths.github.feature.main.mainModule
import com.waysnpaths.github.feature.repository_details.repositoryDetailsModule
import com.waysnpaths.github.feature.repository_list.githubRepositoryListModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

// todo the app should be unit tested, but it already took too much time
class MyApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        startKoin {
            androidContext(this@MyApplication)
            modules(
                appModule, mainModule,
                repositoryDetailsModule,
                githubRepositoryListModule
            )
        }
    }
}
