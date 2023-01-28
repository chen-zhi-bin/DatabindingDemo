package com.program.databindingdemo.api

import com.program.databindingdemo.domain.OnSellResult
import com.program.databindingdemo.domain.ResultData
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("onSell/{page}")
    suspend fun getOnSellList(@Path("page")page:Int):ResultData<OnSellResult>
}