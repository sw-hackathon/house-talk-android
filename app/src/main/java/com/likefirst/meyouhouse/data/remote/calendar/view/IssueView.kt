package com.likefirst.meyouhouse.data.remote.calendar.view

import com.likefirst.meyouhouse.data.remote.calendar.response.IssueDetailResponse

interface IssueDetailView {
    fun getIssueDetailLoading()
    fun getIssueDetailSuccess(response : IssueDetailResponse)
    fun getIssueDetailFailure(code : Int)
}