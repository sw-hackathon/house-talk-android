package com.likefirst.meyouhouse.util

import com.likefirst.meyouhouse.data.dto.community.Articles
import com.likefirst.meyouhouse.data.dto.community.DetailArticle
import com.likefirst.meyouhouse.data.dto.community.PostCommentResult
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import com.likefirst.meyouhouse.data.remote.BaseResponse
import com.likefirst.meyouhouse.data.remote.calendar.response.CalendarResponse
import com.likefirst.meyouhouse.data.remote.calendar.response.IssueComments
import com.likefirst.meyouhouse.data.remote.calendar.response.IssueDetailResponse
import com.likefirst.meyouhouse.data.remote.calendar.response.IssueResponse
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

    // ================== Calendar ==================== //
    @GET("/issue/date")
    fun getIssuesCalendar(
        @Query("year")year: String,
        @Query("month")month: String
    ) : Call<BaseResponse<CalendarResponse>>

    @GET("/issue")
    fun getIssueList(
        @Query("date")date: String
    ) : Call<BaseResponse<IssueResponse>>

    // ================= Issue ================= //
    @GET("/issue/{issueId}")
    fun getIssueDetail(
        @Path("issueId") issueId : Int
    ) : Call<BaseResponse<IssueDetailResponse>>


    //Community main
    @GET("/api/community/home/1")
    fun getArticles() : Call<Articles>

    //Community Detail
    @GET("/api/community/post/{postid}")
    fun getArticlesDetail(@Path("postid") postid:String) : Call<DetailArticle>

    //Community Detail comment post
    @POST("/api/community/comment")
    fun postComment(@Body comment : PostCommentResult) : Call<ResponseBody>

    // Community article post
    @Multipart
    @POST("/api/community")
    fun postCommunityArticle(
        @Part ("userId") userId: MultipartBody.Part,
        @Part ("homeId") homeId: MultipartBody.Part,
        @Part ("content") content: MultipartBody.Part,
        @Part imgs: ArrayList<MultipartBody.Part>?
    ) : Call<ResponseBody>
}