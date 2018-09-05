package com.pigmal.lab.lifecycle

import android.arch.lifecycle.GenericLifecycleObserver
import android.arch.lifecycle.Lifecycle
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        trace()

        lifecycle.addObserver(GenericLifecycleObserver { _, _ ->
            trace()
        })
        lifecycle.addObserver(MyLifecycleObserver())

        findViewById<View>(R.id.button).setOnClickListener { startActivity(Intent(this@MainActivity, Main2Activity::class.java)) }

        findViewById<View>(R.id.jobIntentServiceButton).setOnClickListener {
            SimpleJobIntentService.enqueueWork(this@MainActivity, Intent())
        }
    }

    override fun onStart() {
        super.onStart()
        trace()
    }

    override fun onResume() {
        super.onResume()
        trace()
    }

    override fun onPause() {
        super.onPause()
        trace()
    }

    override fun onStop() {
        super.onStop()
        trace()
    }

    override fun onDestroy() {
        super.onDestroy()
        trace()
    }

    internal fun updateUi() {
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            //TODO update UI
        }
    }
}



