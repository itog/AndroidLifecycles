package com.pigmal.lab.lifecycle

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.ProcessLifecycleOwner
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.SystemClock
import android.support.v4.app.JobIntentService
import android.util.Log
import android.widget.Toast

/**
 * Example implementation of a JobIntentService.
 */
class SimpleJobIntentService : JobIntentService() {

    private val mHandler = Handler()

    override fun onHandleWork(intent: Intent) {
        Log.i(LOG_TAG, "Executing work: $intent")
        var label: String? = intent.getStringExtra("label")
        if (label == null) {
            label = intent.toString()
        }
        toast("Executing: $label")
        for (i in 0..4) {
            Log.i("SimpleJobIntentService", "Running service " + (i + 1)
                    + "/5 @ " + SystemClock.elapsedRealtime())
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
            }

        }
        Log.i(LOG_TAG, "Completed service @ " + SystemClock.elapsedRealtime())
    }

    override fun onDestroy() {
        super.onDestroy()

        if (ProcessLifecycleOwner.get().lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            startActivity(Intent(this, DialogActivity::class.java))
        } else {
            toast("All work complete")
        }
    }

    private fun toast(text: CharSequence) {
        mHandler.post { Toast.makeText(this@SimpleJobIntentService, text, Toast.LENGTH_SHORT).show() }
    }

    companion object {
        private const val LOG_TAG = "IntentService"
        private const val JOB_ID = 1000

        internal fun enqueueWork(context: Context, work: Intent) {
            JobIntentService.enqueueWork(context, SimpleJobIntentService::class.java, JOB_ID, work)
        }
    }
}
