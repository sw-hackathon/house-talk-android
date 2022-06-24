package com.likefirst.meyouhouse.ui.calendar

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.likefirst.meyouhouse.data.dto.calendar.CalendarData
import com.likefirst.meyouhouse.data.remote.calendar.response.IssueComments
import com.likefirst.meyouhouse.databinding.ItemChattingMeBinding
import com.likefirst.meyouhouse.databinding.ItemChattingYouBinding

class IssueDetailChattingRVAdapter (val dataset : ArrayList<IssueComments>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    inner class meViewHolder(binding : ItemChattingMeBinding):RecyclerView.ViewHolder(binding.root){

    }

    inner class youViewHolder(binding : ItemChattingYouBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun getItemViewType(position: Int): Int {
        return if (dataset[position].is_me) {

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

    }
}