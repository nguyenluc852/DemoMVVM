package com.s.demomvvm.data

import com.squareup.moshi.Json

open  class BaseResponse {
    @Json(name ="success") val success:Boolean = false
    @Json(name = "result") val result: String = ""
}