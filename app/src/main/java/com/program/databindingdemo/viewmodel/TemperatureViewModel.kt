package com.program.databindingdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.program.databindingdemo.utils.TempSensorType

class TemperatureViewModel:ViewModel() {
    //关心什么数据
    //传感器支持测试类型：体温，体温+环境温度
    val supportTest:MutableLiveData<TempSensorType> by lazy {
        val mutableLiveData = MutableLiveData<TempSensorType>()
        mutableLiveData.value=TempSensorType.NONE
        mutableLiveData
    }

    //关心数值:体温，环境温度
    //体温
    val bodyTempValue=MutableLiveData<Float>()
    //环境温度
    val evnTempValue=MutableLiveData<Float>()
}