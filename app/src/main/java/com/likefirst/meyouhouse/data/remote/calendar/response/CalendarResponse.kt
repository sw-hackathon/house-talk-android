package com.likefirst.meyouhouse.data.remote.calendar.response

import com.google.gson.annotations.SerializedName

data class CalendarResponse(
    @SerializedName("dates") val dates : ArrayList<Int>
)
