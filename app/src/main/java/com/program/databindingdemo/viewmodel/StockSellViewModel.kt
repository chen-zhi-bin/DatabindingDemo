package com.program.databindingdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StockSellViewModel:ViewModel() {
    //关心数据
    //当前股价
    val currentPrise = MutableLiveData<String>()

    //数量
    val stockCount = MutableLiveData<String>()

    //是否同意协议
    val agreement=MutableLiveData<Boolean>()

    //预计总价
    val totalPrise by lazy {
        val mutableLiveData = MutableLiveData<Float>()
        mutableLiveData.value=0.00f
        mutableLiveData
    }

    public fun updateTotalPrise(){
        val currentPrise = currentPrise.value?.toFloat()?:0.0f
        val stockCount = stockCount.value?.toInt()?:0
        val result = currentPrise * stockCount
//        val totalPrise = String.format("%f.2d", result)
        totalPrise.value = result
    }
}