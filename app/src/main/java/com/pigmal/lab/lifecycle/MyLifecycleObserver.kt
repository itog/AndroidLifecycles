package com.pigmal.lab.lifecycle

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log

class MyLifecycleObserver : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun calledOnCreate(source: LifecycleOwner) {
        trace()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun callOnStart(source: LifecycleOwner) {
        trace()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun callOnAny() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun callOnDestroy() {
        trace()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun callOnPause() {
        trace()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun callOnResume() {
        trace()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun callOnStop() {
        trace()
    }
}
