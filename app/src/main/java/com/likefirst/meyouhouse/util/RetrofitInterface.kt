package com.likefirst.meyouhouse.util

import com.likefirst.meyouhouse.data.dto.community.Article
import com.likefirst.meyouhouse.data.dto.community.Articles
import com.likefirst.meyouhouse.data.dto.community.DetailArticle
import com.likefirst.meyouhouse.data.dto.community.PostCommentResult
import okhttp3.ResponseBody
import com.likefirst.meyouhouse.data.remote.BaseResponse
import com.likefirst.meyouhouse.data.remote.calendar.response.CalendarResponse
import retrofit2.Call
import retrofit2.http.*

interface RetrofitInterface {
    // Example
    // ------------------- UserAuth -------------------------- //
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

    // ================== Calendar ==================== //
    @GET("/issue/date")
    fun getIssuesCalendar(
        @Query("year")year: String,
        @Query("month")month: String
    ) : Call<BaseResponse<CalendarResponse>>


    //Community main
    @GET("api/community/home/1")
    fun getArticles() : Call<Articles>

    //Community Detail
    @GET("api/community/post/{postid}")
    fun getArticlesDetail(@Path("postid") postid:String) : Call<DetailArticle>

    //Community Detail comment post
    @POST("/api/community/comment")
    fun postComment(@Body comment : PostCommentResult) : Call<ResponseBody>
}