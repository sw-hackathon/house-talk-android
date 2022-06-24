package com.likefirst.meyouhouse.ui.search

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.likefirst.meyouhouse.R
import com.likefirst.meyouhouse.data.remote.search.ReviewData
import com.likefirst.meyouhouse.databinding.ItemReviewListBinding

class ReviewAdapter : RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {
    val reviewList = mutableListOf<ReviewData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val binding =
            ItemReviewListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.onBind(reviewList[position])
    }

    override fun getItemCount(): Int = reviewList.size

    class ReviewViewHolder(
        private val binding: ItemReviewListBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ReviewData) {
            binding.apply {
                tvTitle.text = data.name
                tvAddress.text = data.address
                tvHeartPercent.text = "${data.heart} %"
                tvAnswerPercent.text = "${data.answer} %"
                var index = 0
                val stars =
                    listOf(this.ivStar1, this.ivStar2, this.ivStar3, this.ivStar4, this.ivStar5)
                while (index < data.point) {
                    stars[index++].setImageResource(R.drawable.ic_star_filled)
                }
            }
        }
    }
}