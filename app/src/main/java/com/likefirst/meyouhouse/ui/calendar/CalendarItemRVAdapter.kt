package com.likefirst.meyouhouse.ui.calendar

import android.content.Context
import android.util.Log
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import com.likefirst.meyouhouse.R
import com.likefirst.meyouhouse.data.dto.calendar.CalendarData
import com.likefirst.meyouhouse.databinding.ItemCalendarEmptyBinding
import com.likefirst.meyouhouse.databinding.ItemCalendarRvDateBinding
import java.lang.RuntimeException
import java.util.*
import kotlin.collections.ArrayList

class CalendarItemRVAdapter(val calendarList : ArrayList<CalendarData>, val context : Context, val today : String)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val EMPTY_CELL = 0
    private val DATE_CELL = 1
    private lateinit var date : Date
    private var selectedItem = SparseBooleanArray()
    private var preposition = -1

    inner class DateViewHolder(val binding : ItemCalendarRvDateBinding) : RecyclerView.ViewHolder(binding.root) {
        fun initView(position: Int) {
            binding.itemCalendarRvDateTv.text = calendarList[position].dateInt.toString()
            if (position % 7 == 0) {
                val calendarRed = ContextCompat.getColor(context, R.color.calendar_red)
                binding.itemCalendarRvDateTv.setTextColor(calendarRed)
            } else if (position % 7 == 6) {
                val calendarBlue = ContextCompat.getColor(context, R.color.calendar_blue)
                binding.itemCalendarRvDateTv.setTextColor(calendarBlue)
            }
            if (today == calendarList[position].dateInt.toString()) {
                val calendarWhite = ContextCompat.getColor(context, R.color.white)
                binding.itemCalendarRvDateTv.apply {
                    setTextColor(calendarWhite)
                    background = ContextCompat.getDrawable(context, R.drawable.callendar_marker_today)
                }
            } else if(selectedItem.get(position)){
                binding.itemCalendarRvDateTv.background = ContextCompat.getDrawable(context, R.drawable.callendar_marker_current)
            } else {
                binding.itemCalendarRvDateTv.background = null
            }
            if (calendarList[position].issue){
                binding.itemCalendarRvIssueMarker.visibility = View.VISIBLE
            }
        }
    }

    inner class EmptyViewHolder(val binding : ItemCalendarEmptyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun initView(){

        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (calendarList[position].dateInt == 0) {
            EMPTY_CELL
        } else {
            DATE_CELL
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            EMPTY_CELL -> {
                val binding = ItemCalendarEmptyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                EmptyViewHolder(binding)
            }
            DATE_CELL -> {
                val binding = ItemCalendarRvDateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                DateViewHolder(binding)
            } else -> {
                throw RuntimeException("Unknown ViewType Error in CalendarItemRVAdapter")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is EmptyViewHolder -> {
                holder.initView()
            }
            is CalendarItemRVAdapter.DateViewHolder -> {
                holder.initView(position)
                holder.itemView.setOnClickListener {
                    if (!selectedItem.get(position)){
                        selectedItem.clear()
                        selectedItem.put(position, true)
                        if (preposition != -1) notifyItemChanged(preposition)
                        notifyItemChanged(position)
                        preposition = position
                        Log.d("preposition", preposition.toString())
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return 42
    }

    fun setDate(date : Date){
        this.date = date
    }

    fun setIssueMark(date : Int){

    }
}