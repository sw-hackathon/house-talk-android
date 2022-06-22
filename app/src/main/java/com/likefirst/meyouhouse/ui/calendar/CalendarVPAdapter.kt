package com.likefirst.meyouhouse.ui.calendar

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CalendarVPAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    val centerPosition = Int.MAX_VALUE/2

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    override fun createFragment(position: Int): Fragment {
        val pageIndex = position - centerPosition
        val bundle = Bundle()
        bundle.putInt("pageIndex", pageIndex)
        val calendarItemFragment = CalendarItemFragment()
        calendarItemFragment.arguments = bundle
        return calendarItemFragment

    }
}