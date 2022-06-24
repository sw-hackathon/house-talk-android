package com.likefirst.meyouhouse.ui.calendar

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.likefirst.meyouhouse.data.dto.calendar.CalendarData
import com.likefirst.meyouhouse.data.remote.calendar.response.IssueComments
import com.likefirst.meyouhouse.databinding.ItemChattingMeBinding
import com.likefirst.meyouhouse.databinding.ItemChattingYouBinding
import java.lang.RuntimeException

class IssueDetailChattingRVAdapter (val dataset : ArrayList<IssueComments>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val ME = 1
    private val YOU = 2

    inner class meViewHolder(val binding : ItemChattingMeBinding):RecyclerView.ViewHolder(binding.root){
        fun initView(position : Int){
            binding.itemChattingMeDateTv.text = dataset[position].created_at
            binding.itemChattingMeTv.text = dataset[position].content
        }
    }

    inner class youViewHolder(val binding : ItemChattingYouBinding):RecyclerView.ViewHolder(binding.root){
        fun initView(position : Int){
            binding.itemChattingYouDateTv.text = dataset[position].created_at
            binding.itemChattingYouTv.text = dataset[position].content
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (dataset[position].is_me) {
            ME
        } else {
            YOU
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType){
            ME -> {
                val binding = ItemChattingMeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                meViewHolder(binding)
            }
            YOU -> {
                val binding = ItemChattingYouBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                youViewHolder(binding)
            } else -> {
                throw RuntimeException("Unknown ViewType Error in ArchiveCalendarRVAdapter")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder){
            is meViewHolder -> {
                holder.initView(position)
            }
            is youViewHolder -> {
                holder.initView(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}