package com.program.databindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_stock.*

class StockActivity : AppCompatActivity() {

    companion object{
        const val TAG="StockActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stock)
        initEvent()
    }

    private var count=0
    private var prise=0.00f

    /**
     * 设置相关事件监听
     */
    private fun initEvent() {
        currentPriseEt.addTextChangedListener (object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length==0){
                    prise=0.0f
                    handlePrise()
                    return
                }
                Log.d(TAG,"text ==> $s")
                val value:String = s.toString()
                if (value.contains(".")){
                    //包含小数点
                    //456.45655
                    //拿到小数点位置进行判断
                    val pointIndex:Int=value.indexOf(".")
                    //总的长度-小数点的位置>3
                    //456.4655-->首先是判断
                    //index=3,length=8
                    //8-3=5
                    if (value.length-pointIndex>3){
                        //进行删除
                        s?.delete(pointIndex+2,value.length-1)
                    }
                }
                prise=value.toFloat()
                handlePrise()
            }

        })
        stockCountEt.addTextChangedListener (object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length==0){
                    count=0
                    handlePrise()
                    return
                }
                Log.d(TAG,"count text ==> $s")
                count = Integer.parseInt(s.toString())
                handlePrise()
            }

        })
    }

    /**
     * 把结果设置到view上
     */
    private fun handlePrise(){
        if (prise<0.0f){
            return
        }
        if (count<0){
            return
        }
        val totalPrise=prise*count
        println("total==> $totalPrise")

        val format = String.format("%.2f", totalPrise)
        totalPriseTv.text = format
    }
}