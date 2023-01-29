package com.program.databindingdemo.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.program.databindingdemo.R
import com.program.databindingdemo.databinding.ItemOnSellBinding
import com.program.databindingdemo.domain.OnSellItem
import kotlinx.android.synthetic.main.item_on_sell.view.*

class OnSellListAdapter :RecyclerView.Adapter<OnSellListAdapter.InnerHolder>(){

    companion object {
        @JvmStatic
        @BindingAdapter("goodsImages","testValue")
        fun setUpImage(iv:ImageView,goodsImage:String?,testValue:String){
            println("testValue == > $testValue")
            //加载图片
            if (goodsImage !=null){
                Glide.with(iv.context).load("https:$goodsImage").into(iv)
            }else{
                //可以设置加载失败图片

            }
        }
    }


    private val mContentList by lazy {
        mutableListOf<OnSellItem>()
    }

    class InnerHolder(itemView:View,val binding: ItemOnSellBinding) :RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerHolder {
        //这里面的内容不能设置成成员变量
        //只能设置局部变量
       val itemBinding = DataBindingUtil.inflate<ItemOnSellBinding>(LayoutInflater.from(parent.context), R.layout.item_on_sell,parent,false)
        val itemView = itemBinding.root
//        itemView.originalPriseTv.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
        return InnerHolder(itemView,itemBinding)
    }

    override fun onBindViewHolder(holder: InnerHolder, position: Int) {
        //拿到对应位置的数据
        val itemData = mContentList[position]

        //绑定数据，想binding里设置数据
        //要有binding
        //holder.binding.xxx= 拿到的数据
        holder.binding.itemData = itemData

    }

    override fun getItemCount(): Int {
        return mContentList.size
    }

    fun setData(contentList: MutableList<OnSellItem>?) {
        mContentList.clear()
        if (contentList != null) {
            mContentList.addAll(contentList)
        }
        //这里是全部更新
        //如果是添加到头部或尾部就部分更新
        notifyDataSetChanged()
    }
}