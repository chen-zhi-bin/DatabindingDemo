package com.program.databindingdemo.fragment

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.program.databindingdemo.R
import com.program.databindingdemo.adapter.OnSellListAdapter
import com.program.databindingdemo.base.BaseVmFragment
import com.program.databindingdemo.databinding.FragmentOnSellBinding
import com.program.databindingdemo.viewmodel.OnSellViewModel
import kotlinx.android.synthetic.main.fragment_on_sell.view.*

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
            //更新列表
            mAdapter.setData(contentList)

        })
    }

    private val mAdapter by lazy {
            OnSellListAdapter()
    }

    override fun initView() {
        rootView.onSellListView.run {
            //布局管理器
            layoutManager = LinearLayoutManager(context)
            //设置适配器
            adapter = mAdapter
            //todo:设置间距

        }
    }

    override fun getSubLayoutId(): Int {
        return R.layout.fragment_on_sell
    }

}