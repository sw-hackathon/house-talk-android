package com.likefirst.meyouhouse.data.remote.calendar.service

import android.util.Log
import com.likefirst.meyouhouse.data.remote.BaseResponse
import com.likefirst.meyouhouse.data.remote.calendar.response.CalendarResponse
import com.likefirst.meyouhouse.data.remote.calendar.response.IssueResponse
import com.likefirst.meyouhouse.data.remote.calendar.view.CalendarView
import com.likefirst.meyouhouse.data.remote.calendar.view.IssueView
import com.likefirst.meyouhouse.util.ApplicationClass.Companion.retrofit
import com.likefirst.meyouhouse.util.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CalendarService {
    private lateinit var calendarView : CalendarView
    private lateinit var issueView : IssueView

    private val calendarService = retrofit.create(RetrofitInterface::class.java)

    fun setCalendarView(calendarView: CalendarView){
        this.calendarView = calendarView
    }

    fun setIssueView(issueView: IssueView){
        this.issueView = issueView
    }

    fun loadCalendar(year : String, month : String){
        calendarView.onCalendarGetLoading()

        calendarService.getIssuesCalendar(year, month).enqueue(object :
            Callback<BaseResponse<CalendarResponse>>{
            override fun onResponse(
                call: Call<BaseResponse<CalendarResponse>>,
                response: Response<BaseResponse<CalendarResponse>>
            ) {
                val issueList = response.body()!!
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

    fun getIssueList(date : String){
        issueView.onIssueListGetLoading()

        calendarService.getIssueList(date).enqueue(object :
        Callback<BaseResponse<IssueResponse>>{
            override fun onResponse(
                call: Call<BaseResponse<IssueResponse>>,
                response: Response<BaseResponse<IssueResponse>>
            ) {
                val resp = response.body()!!
                when(resp.code){
                    200 -> issueView.onIssueListGetSuccess(resp.result.isClient, resp.result.completed_issues, resp.result.uncompleted_issues)
                    else -> issueView.onIssueListGetFailure(resp.code)
                }
            }

            override fun onFailure(call: Call<BaseResponse<IssueResponse>>, t: Throwable) {
                Log.e("Network fail", "CalendarService_getIssueList" )
            }

        })
    }
}