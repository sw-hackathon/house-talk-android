package com.likefirst.meyouhouse.data.remote.calendar.service

import android.util.Log
import com.likefirst.meyouhouse.data.remote.BaseResponse
import com.likefirst.meyouhouse.data.remote.calendar.response.CalendarResponse
import com.likefirst.meyouhouse.data.remote.calendar.view.CalendarView
import com.likefirst.meyouhouse.util.ApplicationClass.Companion.retrofit
import com.likefirst.meyouhouse.util.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CalendarService {
    private lateinit var calendarView : CalendarView

    private val calendarService = retrofit.create(RetrofitInterface::class.java)

    fun setCalendarView(calendarView: CalendarView){
        this.calendarView = calendarView
    }

    fun loadCalendar(year : String, month : String){
        calendarView.onCalendarGetLoading()

        calendarService.getIssuesCalendar(year, month).enqueue(object :
            Callback<BaseResponse<CalendarResponse>>{
            override fun onResponse(
                call: Call<BaseResponse<CalendarResponse>>,
                response: Response<BaseResponse<CalendarResponse>>
            ) {
                Log.d("response", response.toString())
                val issueList = response.body()!!
                Log.d("response", issueList.toString())
                when (issueList.code){
                    200 -> calendarView.onCalendarGetSuccess(issueList.result.dates)
                    else -> calendarView.onCalendarGetFailure(issueList.code)
                }
            }

            override fun onFailure(call: Call<BaseResponse<CalendarResponse>>, t: Throwable) {
                Log.e("Network fail", "CalendarService_loadCalendar" )
            }

        })
    }
}