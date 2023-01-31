package com.program.databindingdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.program.databindingdemo.utils.TempSensorType

class TemperatureViewModel:ViewModel() {
    //关心什么数据
    //传感器支持测试类型：体温，体温+环境温度
    val supportTest:MutableLiveData<TempSensorType> by lazy {
        val mutableLiveData = MutableLiveData<TempSensorType>()
        mutableLiveData.value=TempSensorType.BODY_TEMP
        mutableLiveData
    }

    //关心数值:体温，环境温度
    //体温
    val bodyTempValue by lazy {
        val mutableLiveData = MutableLiveData<Float>()
        mutableLiveData.value=36.2f
        mutableLiveData
    }
    //环境温度
    val envTempValue by lazy {
        val mutableLiveData = MutableLiveData<Float>()
        mutableLiveData.value=20.0f
        mutableLiveData
    }
}