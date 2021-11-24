package com.s.demomvvm.network.repository.main

import com.s.demomvvm.data.BaseResponse
import com.s.demomvvm.network.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun  getTotalData() = apiHelper.getTotalData()
}