package com.pigmal.lab.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

public class MyLifecycleObserver implements LifecycleObserver{
    static final String TAG = "Observer";

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void calledOnCreate(LifecycleOwner source) {
        Log.v(TAG, "ON_CREATE");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void callOnStart(LifecycleOwner source) {
        Log.v(TAG, "ON_START");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void callOnAny() {
        //Log.v(TAG, "ON_ANY");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void callOnDestroy() {
        Log.v(TAG, "ON_DESTROY");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void callOnPause() {
        Log.v(TAG, "ON_PAUSE");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void callOnResume() {
        Log.v(TAG, "ON_RESUME");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void callOnStop() {
        Log.v(TAG, "ON_STOP");
    }
}
