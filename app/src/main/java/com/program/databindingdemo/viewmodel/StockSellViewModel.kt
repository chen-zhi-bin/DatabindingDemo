package com.program.databindingdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StockSellViewModel:ViewModel() {
    //关心数据
    //当前股价
    val currentPrise = MutableLiveData<String>()

    //数量
    val stockCount = MutableLiveData<String>()

}