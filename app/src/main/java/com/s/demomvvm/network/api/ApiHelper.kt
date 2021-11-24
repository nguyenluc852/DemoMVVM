package com.s.demomvvm.network.api

import com.s.demomvvm.data.BaseResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun getTotalData(): Response<BaseResponse>
}