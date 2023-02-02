package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val text: MutableLiveData<String> by lazy { MutableLiveData<String>() }
}