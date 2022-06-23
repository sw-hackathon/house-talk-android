package com.likefirst.meyouhouse.data.remote

data class BaseResponse<T>(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: T? = null
)
