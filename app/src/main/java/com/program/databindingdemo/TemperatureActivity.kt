package com.program.databindingdemo

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.program.databindingdemo.databinding.ActivityTemperatureBinding
import com.program.databindingdemo.utils.TempSensorType
import com.program.databindingdemo.viewmodel.TemperatureViewModel

class TemperatureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityTemperatureBinding>(
            this,
            R.layout.activity_temperature
        )
        //创建viewModel
        val viewModel = ViewModelProvider(this).get(TemperatureViewModel::class.java)
        //观察viewmodel里的数据变化
        viewModel.apply {
            val that = this@TemperatureActivity
            supportTest.observe(that, Observer {
                //观察支持类型
                when(it){
                    TempSensorType.BODY_ENV_TEMP->{
                        //环境温度和体温
                        if (!binding.bodyAndEvnTempView.isInflated) {
                            binding.bodyAndEvnTempView.viewStub?.inflate()
                        }
                    }
                    TempSensorType.BODY_TEMP->{
                        //体温
                        if (!binding.bodyTempView.isInflated) {
                            binding.bodyTempView.viewStub?.inflate()
                        }
                    }
                    TempSensorType.NONE->{
                        //不支持
                        if (!binding.noSupportView.isInflated) {
                            binding.noSupportView.viewStub?.inflate()
                        }
                    }
                }
            })
        }
    }
}