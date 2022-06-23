package com.likefirst.meyouhouse.ui.calendar

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DateViewModel : ViewModel() {

    val date : MutableLiveData<ArrayList<String>> by lazy {
        MutableLiveData<ArrayList<String>>()
    }

    val year : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val month : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val day : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

}