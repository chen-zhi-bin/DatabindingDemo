package com.program.databindingdemo.views

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener

object InputNumberBindingAdapter {

    const val TAG="InputNumbingAdapter"
    /*
    数据更新---》更新ui
     */
    @JvmStatic
    @BindingAdapter("numValue")
    fun setValue(view:InputNumberView,value: Int){
        //给view设置数据,要判断此次要修改的值，跟显示的值是否一样
        //不一样才修改，防止死循环
        view.number=value
        if (view.number!=value){
            Log.d(TAG,"数据模型变化--》更新ui显示 》 $value")
            view.number=value
        }
    }

    /**
     * ui更新--》数据更新
     */
    @JvmStatic
    @InverseBindingAdapter(attribute = "numValue",event = "numAttrChange")
    fun getValue(view:InputNumberView):Int{
        Log.d(TAG,"通知设置viewModel里的数据变化..")
        return view.number
    }

    @JvmStatic
    @BindingAdapter("numAttrChange")
    fun onNumberChange(view:InputNumberView,listener: InverseBindingListener){
        view.setOnNumberValueChangeListener(object :InputNumberView.OnNumberValueChangeListener{
            override fun onNumberValueChange(value: Int) {
                Log.d(TAG,"触发通知VM数据变化...")
                listener.onChange()
            }

            override fun onNumberMax(maxValue: Int) {

            }

            override fun onNumberMin(minValue: Int) {

            }

        })
    }
}