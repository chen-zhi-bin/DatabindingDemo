package com.program.databindingdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InverseBindingViewModel:ViewModel() {
    //关心的数据
    val currentNumLD =MutableLiveData<Int>()
}