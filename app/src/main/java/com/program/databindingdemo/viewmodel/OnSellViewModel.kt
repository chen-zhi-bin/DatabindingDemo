package com.program.databindingdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.program.databindingdemo.domain.OnSellItem
import com.program.databindingdemo.repository.OnSellRepository
import com.program.databindingdemo.utils.LoadState
import kotlinx.coroutines.launch
import java.lang.Exception

class OnSellViewModel:ViewModel() {

    companion object {
        const val DEFAULT_PAGE = 1
    }

    private var mCurrentPage:Int = DEFAULT_PAGE

    private val repository by lazy {
        OnSellRepository()
    }

    fun loadData() {
        //这个加载是需要ui层转圈（loading）
        //更新状态
        loadState.value = LoadState.LOADING
        //加载第一页的数据
        loadDataByPage(mCurrentPage)
    }

    private fun loadDataByPage(page:Int){
        //根据页码加载数据
        viewModelScope.launch {
            try {
                val result = repository.getOnSellListByPage(page)
//            println("result==${result.code}")
//            println("result==${result.message}")
//            println("result==${result.success}")
//            println("result==${result.data}")
                //对数据进行判断,有可能数据为空，或网络请求出错
                val resultList = result.data.tbk_dg_optimus_material_response.result_list.map_data
                if (resultList.isEmpty()) {
                    loadState.value = LoadState.EMPTY
                }else{
                    //处理数据
                    loadState.value = LoadState.SUCCESS
                    //更新数据
                    contentList.value = resultList
                }
            }catch (e:Exception){
                loadState.value = LoadState.ERROR
            }

        }
    }

    //所关心的数据
    //加载状态：Loading,Success,Empty,Error,None
    val loadState by lazy {
        MutableLiveData<LoadState>()
    }
    //数据列表:contentList
    val contentList by lazy {
        MutableLiveData<MutableList<OnSellItem>>()
    }
}