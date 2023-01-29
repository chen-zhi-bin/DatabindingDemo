package com.program.databindingdemo.utils

import android.graphics.Paint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.program.databindingdemo.R

@BindingAdapter("finalPrise")
fun setUpFinalPrise(textView:TextView,finalPrise:String){
    //格式化数据
    //String-->float
    val result =
        String.format(textView.context.getString(R.string.final_prise_text), finalPrise.toFloat())
    println("result ==>$result")
    //设置中划线
    textView.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
    textView.text=result
}