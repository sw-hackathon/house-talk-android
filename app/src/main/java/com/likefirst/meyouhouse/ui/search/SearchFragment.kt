package com.likefirst.meyouhouse.ui.search

import com.likefirst.meyouhouse.data.remote.search.ReviewData
import com.likefirst.meyouhouse.databinding.FragmentSearchBinding
import com.likefirst.meyouhouse.ui.BaseFragment

class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {
    private lateinit var reviewAdapter: ReviewAdapter
    override fun initAfterBinding() {
        initAdapter()
    }

    private fun initAdapter() {
        reviewAdapter = ReviewAdapter().apply {
            reviewList.addAll(
                listOf(
                    ReviewData("서울ㅇㅇ빌라", "서울특별시 동작구 ㅇㅇ동 1길", 2, 80, 50),
                    ReviewData("서울ㅇㅇ빌라", "서울특별시 동작구 ㅇㅇ동 1길", 2, 80, 50),
                    ReviewData("서울ㅇㅇ빌라", "서울특별시 동작구 ㅇㅇ동 1길", 2, 80, 50),
                    ReviewData("서울ㅇㅇ빌라", "서울특별시 동작구 ㅇㅇ동 1길", 2, 80, 50),
                    ReviewData("서울ㅇㅇ빌라", "서울특별시 동작구 ㅇㅇ동 1길", 2, 80, 50),
                    ReviewData("서울ㅇㅇ빌라", "서울특별시 동작구 ㅇㅇ동 1길", 2, 80, 50),
                    ReviewData("서울ㅇㅇ빌라", "서울특별시 동작구 ㅇㅇ동 1길", 2, 80, 50),
                    ReviewData("서울ㅇㅇ빌라", "서울특별시 동작구 ㅇㅇ동 1길", 2, 80, 50),
                    ReviewData("서울ㅇㅇ빌라", "서울특별시 동작구 ㅇㅇ동 1길", 2, 80, 50),
                    ReviewData("서울ㅇㅇ빌라", "서울특별시 동작구 ㅇㅇ동 1길", 2, 80, 50),
                    ReviewData("서울ㅇㅇ빌라", "서울특별시 동작구 ㅇㅇ동 1길", 2, 80, 50),
                    ReviewData("서울ㅇㅇ빌라", "서울특별시 동작구 ㅇㅇ동 1길", 2, 80, 50),
                )
            )
            notifyDataSetChanged()
        }
        binding.rvReviews.adapter = reviewAdapter
    }
}