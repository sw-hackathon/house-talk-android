package com.likefirst.meyouhouse.ui.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.likefirst.meyouhouse.data.remote.calendar.response.Issuedata
import com.likefirst.meyouhouse.databinding.ItemCalendarHappyRvBinding
import java.util.*
import kotlin.collections.ArrayList

class CalendarIssueRVAdapter(val issueList : ArrayList<Issuedata>) : RecyclerView.Adapter<CalendarIssueRVAdapter.ViewHolder>() {
    inner class ViewHolder(val binding : ItemCalendarHappyRvBinding) : RecyclerView.ViewHolder(binding.root) {
        fun initView(position : Int){
            binding.itemCalendarHappyCategoryTv.text = issueList[position].category
            binding.itemCalendarHappyTitleTv.text = issueList[position].title
        }
    }

    interface CalendarIssueSelectedListener{
        // 빈 날짜칸 선택 리스너 -> DiaryActivity
        fun onIssueSelectedListener(id : Int)
    }

    private lateinit var mCalendarIssueSelectedListener: CalendarIssueRVAdapter.CalendarIssueSelectedListener

    fun setOnIssueSelectedListener(calendarIssueSelectedListener: CalendarIssueRVAdapter.CalendarIssueSelectedListener){
        mCalendarIssueSelectedListener = calendarIssueSelectedListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCalendarHappyRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.initView(position)
        holder.itemView.setOnClickListener {
            mCalendarIssueSelectedListener.onIssueSelectedListener(issueList[position].id)
        }
    }

    override fun getItemCount(): Int {
        return issueList.size
    }
}