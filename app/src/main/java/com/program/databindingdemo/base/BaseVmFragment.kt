package com.program.databindingdemo.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/*
还不知道具体布局
 */
abstract class BaseVmFragment<T : ViewDataBinding, VM : ViewModel> : BaseViewFragment<T>() {

    protected lateinit var viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //创建ViewModel
        initViewModel()
        //观察ViewModel数据变化 --》更新ui
        observerData()
        //设置相关的事件
        initEvent()
        //开始加载数据
        startLoadData()
    }

    open fun startLoadData(){

    }

    open fun initEvent() {

    }

    open fun observerData(){

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(getSubVMClass())

    }

    abstract fun getSubVMClass(): Class<VM>

}