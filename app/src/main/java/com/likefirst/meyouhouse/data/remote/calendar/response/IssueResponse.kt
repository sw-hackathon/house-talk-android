package com.likefirst.meyouhouse.data.remote.calendar.response

import com.google.gson.annotations.SerializedName

data class IssueDetailResponse(
    @SerializedName("id") val id : Int,
    @SerializedName("title") val title : String,
    @SerializedName("content") val content : String,
    @SerializedName("category") val category : String,
    @SerializedName("room_number") val roomNumber : String,
    @SerializedName("is_completed") val is_completed : Boolean,
    @SerializedName("imgs") val imgs : ArrayList<String>,
    @SerializedName("created_at") val created_at : String,
    @SerializedName("comments") val comments : ArrayList<IssueComments>
)

data class IssueComments(
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("is_client") val is_client : Boolean,
    @SerializedName("is_me") val is_me : Boolean,
    @SerializedName("created_at") val created_at : String,
    @SerializedName("content") val content : String
    )