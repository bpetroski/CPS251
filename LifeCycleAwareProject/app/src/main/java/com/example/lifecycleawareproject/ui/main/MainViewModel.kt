package com.example.lifecycleawareproject.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.lifecycleawareproject.myObserver
import java.time.LocalTime

class MainViewModel : ViewModel() {

    private var history: MutableLiveData<String> = MutableLiveData()

    fun updateLog(){
        history.setValue("")
    }

/*
    var lifeCycleHistory = ""

    fun endLine():String{
        lifeCycleHistory += "********\n"
        return lifeCycleHistory
    }

    fun activityCreated(): String{
        if(lifeCycleHistory.isNullOrEmpty()){
            lifeCycleHistory = "onCreate was fired on " + LocalTime.now() + "\n"
        }else{
            lifeCycleHistory += "onCreate was fired on " + LocalTime.now() + "\n"
        }
        return lifeCycleHistory
    }



    fun start():String{
        lifeCycleHistory += "onStart was fired on " + LocalTime.now() + "\n"
        return lifeCycleHistory
    }

    fun pause():String{
        lifeCycleHistory += "onPause was fired on " + LocalTime.now() + "\n"
        return lifeCycleHistory
    }

    fun resume(): String{
        lifeCycleHistory += "onResume was fired on " + LocalTime.now() + "\n"
        return lifeCycleHistory
    }

 */
    // TODO: Implement the ViewModel
}