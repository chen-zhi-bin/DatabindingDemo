package com.program.databindingdemo.utils

import android.text.TextUtils
import androidx.databinding.InverseMethod

object Converter {

    @InverseMethod("string2Int")
    @JvmStatic
    fun int2String(value:Int?):String{
        if (value==null){
            return ""
        }
        return value.toString()
    }

    @JvmStatic
    fun string2Int(value: String):Int?{
        if (TextUtils.isEmpty(value)) {
            return null
        }
        return value.toInt()
    }
}