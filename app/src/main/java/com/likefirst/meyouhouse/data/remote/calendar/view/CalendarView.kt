package com.likefirst.meyouhouse.data.remote.calendar.view

import com.likefirst.meyouhouse.data.remote.calendar.response.Issuedata

interface CalendarView {
    fun onCalendarGetLoading()
    fun onCalendarGetSuccess(dates : ArrayList<Int>)
    fun onCalendarGetFailure(code : Int)
}

interface IssueView {
    fun onIssueListGetLoading()
    fun onIssueListGetSuccess(isClient : Boolean, completed_list : ArrayList<Issuedata>, uncompleted_list : ArrayList<Issuedata>)
    fun onIssueListGetFailure(code : Int)
}