package com.likefirst.meyouhouse.data.remote.calendar.service

import android.util.Log
import com.likefirst.meyouhouse.data.remote.BaseResponse
import com.likefirst.meyouhouse.data.remote.calendar.response.IssueDetailResponse
import com.likefirst.meyouhouse.data.remote.calendar.view.CalendarView
import com.likefirst.meyouhouse.data.remote.calendar.view.IssueDetailView
import com.likefirst.meyouhouse.util.ApplicationClass
import com.likefirst.meyouhouse.util.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IssueService {
    private lateinit var issueDetailView : IssueDetailView

    private val issueService = ApplicationClass.retrofit.create(RetrofitInterface::class.java)

    fun setIssueDetailView(issueDetailView: IssueDetailView) {
        this.issueDetailView = issueDetailView
    }

    fun getIssueDetail(id : Int){
        issueDetailView.getIssueDetailLoading()

        issueService.getIssueDetail(id).enqueue(object :
        Callback<BaseResponse<IssueDetailResponse>>{
            override fun onResponse(
                call: Call<BaseResponse<IssueDetailResponse>>,
                response: Response<BaseResponse<IssueDetailResponse>>
            ) {
                val resp = response.body()!!
                when(resp.code){
                    200 -> issueDetailView.getIssueDetailSuccess(resp.result)
                    else -> issueDetailView.getIssueDetailFailure(resp.code)
                }
            }

            override fun onFailure(call: Call<BaseResponse<IssueDetailResponse>>, t: Throwable) {
                Log.e("Network fail", "IssueService_getIssueDetail" )
            }

        })
    }
}