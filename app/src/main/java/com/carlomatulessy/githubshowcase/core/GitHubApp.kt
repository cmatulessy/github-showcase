package com.carlomatulessy.githubshowcase.core

import android.app.Application
import com.carlomatulessy.githubshowcase.core.di.KoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GitHubApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@GitHubApp)
            modules(KoinModules.modules)
        }
    }
}