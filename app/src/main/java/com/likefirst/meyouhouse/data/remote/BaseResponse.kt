package com.likefirst.meyouhouse.data.remote

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("status") val code : Int,
    @SerializedName("success") val isSuccess: Boolean,
    @SerializedName("message") val message : String,
    @SerializedName("data") val result : T
)