package com.likefirst.meyouhouse.ui.calendar

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.likefirst.meyouhouse.data.dto.calendar.CalendarData
import com.likefirst.meyouhouse.databinding.ItemChattingMeBinding
import com.likefirst.meyouhouse.databinding.ItemChattingYouBinding

class IssueDetailChattingRVAdapter ()
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class meViewHolder(binding : ItemChattingMeBinding):RecyclerView.ViewHolder(binding.root){

    }

    inner class youViewHolder(binding : ItemChattingYouBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun getItemViewType(position: Int): Int {
        return if (calendarList[position].diaryDate == null) {
            if (calendarList[position].dateInt == 0) {
                EMPTY_CELL
            } else {
                DATE_CELL
            }
        }}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}