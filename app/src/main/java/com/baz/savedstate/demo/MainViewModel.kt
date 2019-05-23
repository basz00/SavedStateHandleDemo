package com.baz.savedstate.demo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

internal class MainViewModel : ViewModel() {

    val randomNumberLiveData = MutableLiveData<Int>()

    fun generateRandomNumber() {
        randomNumberLiveData.value = (0..100).random()
    }
}