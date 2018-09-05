package com.pigmal.lab.lifecycle

import android.util.Log


fun getClassName(): String {
    var name = "Unknown"
    try {
        name = Thread.currentThread().stackTrace[4].className.substringAfterLast(".")
    } catch (e: ArrayIndexOutOfBoundsException) {
        e.printStackTrace()
    }

    return name
}

fun getMethodName(): String {
    var name = "Unknown"
    try {
        name = Thread.currentThread().stackTrace[4].methodName
    } catch (e: ArrayIndexOutOfBoundsException) {
        e.printStackTrace()
    }

    return name
}

fun trace() {
    Log.v(TAG, "${System.currentTimeMillis()} ${getClassName()}: ${getMethodName()}() called")
}

const val TAG = "AndroidLifecycles"
