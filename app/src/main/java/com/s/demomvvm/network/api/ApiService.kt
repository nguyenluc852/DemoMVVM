package com.s.demomvvm.network.api

import com.s.demomvvm.data.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.HeaderMap

interface ApiService {

    @GET("totalData")
    suspend fun getTotalData():Response<BaseResponse>

}