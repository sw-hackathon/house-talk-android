package com.likefirst.meyouhouse.ui.community

import android.content.Intent
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.likefirst.meyouhouse.data.dto.community.Article
import com.likefirst.meyouhouse.databinding.FragmentCommunityBinding
import com.likefirst.meyouhouse.ui.BaseFragment

class CommunityFragment : BaseFragment<FragmentCommunityBinding>(FragmentCommunityBinding::inflate) {

    //Dummy Article Data
    val DummyArticles = mutableListOf<Article>(Article("안녕하세요",date="6/22 05:24",commentCount=5),Article("안녕하세요2",date="6/22 05:24",commentCount=5),Article("안녕하세요",date="6/22 05:24",commentCount=5))
    private lateinit var articleAdapter : ArticleRVAdapter

    override fun initAfterBinding() {

        initFloatButton()

        // TODO 리사이클러뷰 만들기
        // TODO 게시글 눌렀을때 상세정보 뿌려주기
        initArticleRecyclerView()

    }


    private fun initFloatButton() {
        binding.addArticleFloatingButton.setOnClickListener {
            context?.let{
                val intent = Intent(it,ArticlePostingActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun initArticleRecyclerView() {
        articleAdapter = ArticleRVAdapter(DummyArticles, viewOnClickListener = {
            context?.let{
                val intent = Intent(it,ArticleDetailActivity::class.java)
                startActivity(intent)
            }
        })
        binding.communityArticleRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.communityArticleRecyclerView.adapter = articleAdapter

    }



    companion object {
        const val TAG = "CommunityFg"
    }
}