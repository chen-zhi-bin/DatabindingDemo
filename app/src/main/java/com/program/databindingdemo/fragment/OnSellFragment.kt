package com.program.databindingdemo.fragment

import androidx.lifecycle.Observer
import com.program.databindingdemo.R
import com.program.databindingdemo.base.BaseVmFragment
import com.program.databindingdemo.databinding.FragmentOnSellBinding
import com.program.databindingdemo.viewmodel.OnSellViewModel

class OnSellFragment:BaseVmFragment<FragmentOnSellBinding,OnSellViewModel>() {
    override fun getSubVMClass(): Class<OnSellViewModel> {
        return OnSellViewModel::class.java
    }

    override fun startLoadData() {
        //加载数据
        viewModel.loadData()
    }

    override fun observerData() {
        super.observerData()
        //观察Viewmodel里的数据变化
        viewModel.loadState.observe(this, Observer { newState ->
            println("newState+$newState")
            //更新ui
            //todo:
        })
        viewModel.contentList.observe(this, Observer { contentList ->
            //当内容列表发生变化的时候，就会通知到这里了
            println("content+$contentList.size")
            //todo:

        })
    }

    override fun getSubLayoutId(): Int {
        return R.layout.fragment_on_sell
    }

}