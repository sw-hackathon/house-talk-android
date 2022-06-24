package com.likefirst.meyouhouse.data.remote.auth

data class GetHomeByCodeResponse(
    val id: Int,
    val host_id: String,
    val name: String,
    val code: String
)
