package com.example.addnamesavedata.ui.main

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {

    var nameList: MutableLiveData<String> = MutableLiveData()
    var name = ""

    fun addName(){
        if(nameList.value.isNullOrEmpty()){
            nameList.value = name + "\n"
        }else{
            nameList.value += name + "\n"
        }
    }
}