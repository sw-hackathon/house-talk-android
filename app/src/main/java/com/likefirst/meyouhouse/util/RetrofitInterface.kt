package com.likefirst.meyouhouse.util

import com.likefirst.meyouhouse.data.remote.BaseResponse
import com.likefirst.meyouhouse.data.remote.auth.GetHomeByCodeResponse
import com.likefirst.meyouhouse.data.remote.auth.PostHomeRequest
import com.likefirst.meyouhouse.data.remote.auth.PostHomeResponse
import retrofit2.Call
import retrofit2.http.*

interface RetrofitInterface {
    // Example
    // ------------------- UserAuth -------------------------- //
    @GET("/auth/home/{code}")
    fun getHomeByCode(@Path("code") code: String): Call<BaseResponse<GetHomeByCodeResponse>>

    @POST("/auth/home")
    fun postHome(@Body body: PostHomeRequest): Call<BaseResponse<PostHomeResponse>>
//    @POST("/auth/google")
//    fun login(@Body email: UserEmail) : Call<LoginResponse>
//
//    @GET("/auth/jwt")
//    fun autoLogin() : Call<LoginResponse>
//    //@Header("x-access-token") jwt: String
//    @POST("/users")
//    fun signUp(@Body user: UserSign) : Call<LoginResponse>
//
//    @GET("/users/{useridx}")
//    fun getProfile(@Path("useridx") useridx: Int): Call<GetProfileResponse>
//
//    @PATCH("/users/{userIdx}/sad")
//    fun updateIsSad(
//        @Path("userIdx") userIdx: Int,
//        @Body isSad : UserIsSad
//    ) : Call<BaseResponse<String>>
}