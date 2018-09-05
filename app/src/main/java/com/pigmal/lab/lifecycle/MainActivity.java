package com.pigmal.lab.lifecycle;

import android.arch.lifecycle.GenericLifecycleObserver;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "Lifecycle";
    static final String TAG2 = "Lifecycle2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG, getLifecycle().getCurrentState().name());
        //getLifecycle().addObserver(new MyLifecycleObserver());
        getLifecycle().addObserver(new GenericLifecycleObserver() {
            @Override
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Log.v(TAG2, "onStateChanged " + event.name());
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });

        findViewById(R.id.jobIntentServiceButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleJobIntentService.enqueueWork(MainActivity.this, new Intent());
//                JobIntentService jis = new SimpleJobIntentService();
//                startService(new Intent(MainActivity.this, SimpleJobIntentService.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, getLifecycle().getCurrentState().name());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, getLifecycle().getCurrentState().name());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, getLifecycle().getCurrentState().name());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, getLifecycle().getCurrentState().name());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, getLifecycle().getCurrentState().name());
    }

    void updateUi() {
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            //TODO update UI
        }
    }
}



