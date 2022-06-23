package com.likefirst.meyouhouse.ui.calendar

import com.likefirst.meyouhouse.databinding.ActivityIssueDetailBinding
import com.likefirst.meyouhouse.ui.BaseActivity

class IssueDetailActivity : BaseActivity<ActivityIssueDetailBinding>(ActivityIssueDetailBinding::inflate) {
    override fun initAfterBinding() {
        val id = intent.getIntExtra("id", 0)

    }
}