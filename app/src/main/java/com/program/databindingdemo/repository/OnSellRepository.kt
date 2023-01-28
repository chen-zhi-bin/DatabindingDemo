package com.program.databindingdemo.repository

import com.program.databindingdemo.api.RetrofitClient

class OnSellRepository {

    suspend fun getOnSellListByPage(page: Int) = RetrofitClient.apiService.getOnSellList(page)

}