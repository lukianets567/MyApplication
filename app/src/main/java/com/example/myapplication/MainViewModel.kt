package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _savedState = MutableLiveData<Map<String, Int>>()
    val savedState: LiveData<Map<String, Int>> = _savedState

    fun saveSt(radioInt1:Int, radioInt2: Int, radioInt3: Int, textViewIntValue: Int){
        _savedState.value = mapOf("RADIO_1" to radioInt1, "RADIO_2" to radioInt2, "RADIO_3" to radioInt3, "TEXT_1" to textViewIntValue)
    }
}