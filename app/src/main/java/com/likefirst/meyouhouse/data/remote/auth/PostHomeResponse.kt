package com.likefirst.meyouhouse.data.remote.auth

data class PostHomeResponse(
    val home: Home
)

data class Home(
    val id: Int,
    val name: String,
    val host_id: Int,
    val code: String
)