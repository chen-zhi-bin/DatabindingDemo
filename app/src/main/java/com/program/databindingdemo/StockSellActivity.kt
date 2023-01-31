package com.program.databindingdemo

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.program.databindingdemo.databinding.ActivityStockSellBinding
import com.program.databindingdemo.viewmodel.StockSellViewModel
import com.program.databindingdemo.views.PriseNumberFilter
import kotlinx.android.synthetic.main.activity_stock_sell.*

class StockSellActivity:AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this).get(StockSellViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityStockSellBinding>(
            this,
            R.layout.activity_stock_sell
        )
        //ui变化去通知数据变化
        //监听ui数据变化
        priseTv.filters = arrayOf(PriseNumberFilter())
        binding.lifecycleOwner=this //没有这个的话，数据更新就没法通知ui更新
        binding.viewModel=viewModel
        viewModel.apply {
            val that=this@StockSellActivity
            currentPrise.observe(that, Observer {
                println("当前价格变化了 ==>$it")
                updateTotalPrise()
            })
            stockCount.observe(that, Observer {
                println("出售的股票数量变化了==》 $it")
                updateTotalPrise()
            })
            agreement.observe(that, Observer {
                println("has check ==> $it")
            })
        }
    }
    //数据变化时通知ui
    //监听数据变化
    fun updatePrise(view: View){
        viewModel.currentPrise.value="56.90"
    }
}