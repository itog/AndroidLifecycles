package com.pigmal.lab.lifecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
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
}
