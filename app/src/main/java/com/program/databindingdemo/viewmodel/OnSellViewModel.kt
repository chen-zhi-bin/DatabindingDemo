package com.program.databindingdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.program.databindingdemo.domain.OnSellItem
import com.program.databindingdemo.utils.LoadState

class OnSellViewModel:ViewModel() {
    //所关心的数据
    //加载状态：Loading,Success,Empty,Error,None
    val loadState by lazy {
        MutableLiveData<LoadState>()
    }
    //数据列表:contentList
    val contentList by lazy {
        MutableLiveData<MutableList<OnSellItem>>()
    }
}