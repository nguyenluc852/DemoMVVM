package com.s.demomvvm.network.api

import com.s.demomvvm.data.BaseResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl  @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun getTotalData(): Response<BaseResponse> {
        return   apiService.getTotalData()
    }
}