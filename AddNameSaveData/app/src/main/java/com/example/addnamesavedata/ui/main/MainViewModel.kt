package com.example.addnamesavedata.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var nameList = "No names to display"

    fun addName(value: String) {

        if(nameList == "No names to display" && value != "clearNames"){
            nameList = "" // clear default message to diplay names
        }

        this.nameList += value + "\n" // add names

        if(value == "clearNames"){ // runs if user enters "clearNames" as name
            nameList = "No names to display" // clear names and reset
        }
    }
    fun getNames(): String {
        return nameList
    }
}