package com.likefirst.meyouhouse.data.remote.calendar.response

import com.google.gson.annotations.SerializedName

data class CalendarResponse(
    @SerializedName("dates") val dates : ArrayList<Int>
)

data class Issuedata(
    @SerializedName("id") val id : Int,
    @SerializedName("category") val category : String,
    @SerializedName("title") val title : String
    )

data class IssueResponse(
    @SerializedName("is_client") val isClient : Boolean,
    @SerializedName("uncompleted_issues") val uncompleted_issues : ArrayList<Issuedata>,
    @SerializedName("completed_issues") val completed_issues : ArrayList<Issuedata>
)