package com.ebookfrenzy.carddemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    companion object {
        var intlist: ArrayList<ArrayList<Int>> = arrayListOf()
    }

    fun generateArr():ArrayList<ArrayList<Int>>{
        if(intlist.size == 0){
            val num = 7
            var i = 0
            while (i <= num) {
                intlist.add(arrayListOf((0..7).random(), (0..7).random(), (0..7).random()))
                i++
            }
        }
        return intlist
    }
}