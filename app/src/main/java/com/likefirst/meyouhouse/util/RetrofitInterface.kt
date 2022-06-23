package com.likefirst.meyouhouse.util

import com.likefirst.meyouhouse.data.remote.auth.GetHomeByCodeResponse
import retrofit2.Call
import retrofit2.http.*

interface RetrofitInterface {
    // Example
    // ------------------- UserAuth -------------------------- //
    @GET("/auth/home/{code}")
    fun getHomeByCode(@Path("code") code: String): Call<GetHomeByCodeResponse>

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