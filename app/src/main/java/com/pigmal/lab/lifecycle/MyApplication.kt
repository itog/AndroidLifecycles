package com.pigmal.lab.lifecycle

import android.app.Application
import android.arch.lifecycle.GenericLifecycleObserver
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ProcessLifecycleOwner
import android.content.res.Configuration
import android.util.Log

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        trace()

        ProcessLifecycleOwner.get().lifecycle.addObserver(GenericLifecycleObserver { _, event ->
            trace()
        })
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        trace()
    }

    override fun onTerminate() {
        super.onTerminate()
        trace()
    }
}
