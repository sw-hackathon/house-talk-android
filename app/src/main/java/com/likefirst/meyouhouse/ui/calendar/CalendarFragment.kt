package com.likefirst.meyouhouse.ui.calendar

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.likefirst.meyouhouse.R
import com.likefirst.meyouhouse.data.remote.calendar.response.Issuedata
import com.likefirst.meyouhouse.data.remote.calendar.service.CalendarService
import com.likefirst.meyouhouse.data.remote.calendar.view.CalendarView
import com.likefirst.meyouhouse.data.remote.calendar.view.IssueView
import com.likefirst.meyouhouse.databinding.FragmentCalendarBinding
import com.likefirst.meyouhouse.ui.BaseFragment
import java.util.*

class CalendarFragment : BaseFragment<FragmentCalendarBinding>(FragmentCalendarBinding::inflate),
    IssueView {

    val model : DateViewModel by viewModels()
    val mCalendar: Calendar = GregorianCalendar.getInstance()

    companion object {
        var year : Int = 0
        var month : Int = 0
        var day : Int = 0
    }

    override fun initAfterBinding() {
        initCalendar()
        initIssues()
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

    fun initIssues(){
        mCalendar.time = Date()
        year = mCalendar.get(Calendar.YEAR)
        month = mCalendar.get(Calendar.MONTH)+1
        day = mCalendar.get(Calendar.DAY_OF_MONTH)
        model.date.value = arrayListOf("$year","$month","$day")
        val MMddObserver = Observer<ArrayList<String>>{ dataSet ->
            val MMdd = dataSet[1]+"."+dataSet[2]
            binding.callendarAngryDateTv.text = MMdd
            binding.callendarHappyDateTv.text = MMdd
        }
        model.date.observe(this, MMddObserver)
        loadIssues()
    }

    fun loadIssues(){
        val yyMMddObserver = Observer<ArrayList<String>>{ dataSet ->
            val yyMMdd = dataSet[0]+"-"+dataSet[1]+"-"+dataSet[2]
            val calendarService = CalendarService()
            calendarService.setIssueView(this)
            calendarService.getIssueList(yyMMdd)
        }
        model.date.observe(this, yyMMddObserver)
    }

    fun initIssueLists(completed_list : ArrayList<Issuedata>, uncompleted_list : ArrayList<Issuedata>){
        val completed_adapter = CalendarIssueRVAdapter(completed_list)
        val uncompleted_adapter = CalendarIssueRVAdapter(uncompleted_list)
        binding.calendarAngryRv.apply {
            adapter = uncompleted_adapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }
        binding.calendarHappyRv.apply {
            adapter = completed_adapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }
    }

    override fun onIssueListGetLoading() {

    }

    override fun onIssueListGetSuccess(isClient : Boolean, completed_list : ArrayList<Issuedata>, uncompleted_list : ArrayList<Issuedata>) {
        initIssueLists(completed_list, uncompleted_list)

    }

    override fun onIssueListGetFailure(code: Int) {

    }
}