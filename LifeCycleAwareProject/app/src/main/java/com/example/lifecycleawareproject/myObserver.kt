package com.example.lifecycleawareproject

import android.content.Context
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.example.lifecycleawareproject.ui.main.MainFragment
import com.example.lifecycleawareproject.ui.main.MainViewModel
import java.time.LocalTime

class myObserver: LifecycleObserver {

    private val LOG_TAG = "myObserver"
    var lifeCycleHistory = ""

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.i(LOG_TAG, "onResume")
        lifeCycleHistory += "onResume was fired on " + LocalTime.now() + "\n"

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.i(LOG_TAG, "onPause")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.i(LOG_TAG, "onCreate")
        lifeCycleHistory += "onCreate was fired on " + LocalTime.now() + "\n"
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.i(LOG_TAG, "onStart")
        lifeCycleHistory += "onStart was fired on " + LocalTime.now() + "\n"
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.i(LOG_TAG, "onStop")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.i(LOG_TAG, "onDestroy")
    }

    fun getLifecycle():String{
        return lifeCycleHistory
    }

}