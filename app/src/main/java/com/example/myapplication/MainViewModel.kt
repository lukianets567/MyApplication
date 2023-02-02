package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val text: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val savedState: LiveData<Map<String, Int>> get() = savedState1
    val savedState1 = MutableLiveData<Map<String, Int>>()

    fun saveSt(radioInt1:Int, radioInt2: Int, radioInt3: Int, textViewIntValue: Int){
        savedState1.value = mapOf("KEY1" to radioInt1, "KEY2" to radioInt2, "KEY3" to radioInt3, "KEY4" to textViewIntValue)
    }
}