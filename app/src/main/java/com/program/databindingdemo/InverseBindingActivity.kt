package com.program.databindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.program.databindingdemo.databinding.ActivityInverseBindingBinding


import com.program.databindingdemo.viewmodel.InverseBindingViewModel

class InverseBindingActivity : AppCompatActivity() {
    companion object{
        val TAG="InverseBindingActivity"
    }

    val viewModel by lazy {
        ViewModelProvider(this).get(InverseBindingViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityInverseBindingBinding>(
            this,
            R.layout.activity_inverse_binding
        )

        binding.vm=viewModel
        viewModel.currentNumLD.observe(this, Observer {
            Log.d(TAG,"on ui data change ==>$it")
        })
        binding.lifecycleOwner =this//没有这个的话,没法观察数据，当数据更新，ui不会更新

    }

    fun testUpdateData(view:View){
        viewModel.currentNumLD.value=40
    }
}