package com.likefirst.meyouhouse.ui.calendar

import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.likefirst.meyouhouse.R
import com.likefirst.meyouhouse.data.remote.calendar.service.CalendarService
import com.likefirst.meyouhouse.data.remote.calendar.view.CalendarView
import com.likefirst.meyouhouse.databinding.FragmentCalendarBinding
import com.likefirst.meyouhouse.ui.BaseFragment
import java.util.*

class CalendarFragment : BaseFragment<FragmentCalendarBinding>(FragmentCalendarBinding::inflate) {

    lateinit var currentDate : Date
    val mCalendar: Calendar = GregorianCalendar.getInstance()

    companion object {
        var pageIndex = 0
    }

    override fun initAfterBinding() {
        initCalendar()
    }

    fun initCalendar(){
        mCalendar.time = Date()

        val calendarAdapter = CalendarVPAdapter(this)
        binding.calendarVp.apply {
            adapter = calendarAdapter
            overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            offscreenPageLimit = 1
            setCurrentItem(Int.MAX_VALUE/2, false)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {

//                    //pageIndex 설정 (현재 달을 기준값 0으로 잡음)
//                    val centerPosition = Int.MAX_VALUE/2
//                    pageIndex = position - centerPosition
//
//                    현재 표시되는 달 텍스트 변환
//                    if(MONTH_TODAY + pageIndex >= 0){
//                        val monthIndex = (MONTH_TODAY + pageIndex) % 12
//                        val year = (MONTH_TODAY + pageIndex) / 12 + YEAR_TODAY
//                        binding.archiveCalendarMonthTv.text = monthNames[monthIndex]
//                        binding.archiveCalendarYearTv.text = year.toString()
//                    } else {
//                        val monthIndexAbs = kotlin.math.abs(MONTH_TODAY + pageIndex)
//                        val year = YEAR_TODAY - ((monthIndexAbs-1) / 12) - 1
//                        val monthIndex = 12 - (monthIndexAbs % 12)
//                        if (monthIndex == 12){
//                            binding.archiveCalendarMonthTv.text = monthNames[0]
//                        } else {
//                            binding.archiveCalendarMonthTv.text = monthNames[monthIndex]
//                        }
//                        binding.archiveCalendarYearTv.text = year.toString()
//                    }
                    super.onPageSelected(position)
                }
            })
        }
    }
}