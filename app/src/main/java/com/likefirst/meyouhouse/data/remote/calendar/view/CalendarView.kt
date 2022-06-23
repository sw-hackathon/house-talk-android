package com.likefirst.meyouhouse.data.remote.calendar.view

interface CalendarView {
    fun onCalendarGetLoading()
    fun onCalendarGetSuccess(dates : ArrayList<Int>)
    fun onCalendarGetFailure(code : Int)
}