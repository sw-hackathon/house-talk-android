package com.likefirst.meyouhouse.ui.calendar

import android.util.Log
import com.likefirst.meyouhouse.data.remote.calendar.response.IssueDetailResponse
import com.likefirst.meyouhouse.data.remote.calendar.service.IssueService
import com.likefirst.meyouhouse.data.remote.calendar.view.IssueDetailView
import com.likefirst.meyouhouse.databinding.ActivityIssueDetailBinding
import com.likefirst.meyouhouse.ui.BaseActivity

class IssueDetailActivity : BaseActivity<ActivityIssueDetailBinding>(ActivityIssueDetailBinding::inflate), IssueDetailView {
    override fun initAfterBinding() {
        val id = intent.getIntExtra("id", 0)
        val issueService = IssueService()
        issueService.setIssueDetailView(this)
        issueService.getIssueDetail(id)
    }

    override fun getIssueDetailLoading() {

    }

    override fun getIssueDetailSuccess(response : IssueDetailResponse) {
        binding.issueDetailHeaderTv.text = response.category
        binding.issueDetailAddressTv.text = response.roomNumber
        binding.issueDetailDateTv.text = response.created_at
        binding.issueDetailTitleTv.text = response.title
        binding.issueDetailContentTv.text = response.content
    }

    override fun getIssueDetailFailure(code: Int) {

    }
}