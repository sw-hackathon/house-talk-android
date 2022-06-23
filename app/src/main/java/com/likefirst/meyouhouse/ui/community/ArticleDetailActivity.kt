package com.likefirst.meyouhouse.ui.community

import androidx.recyclerview.widget.LinearLayoutManager
import com.likefirst.meyouhouse.data.dto.community.Article
import com.likefirst.meyouhouse.data.dto.community.Comment
import com.likefirst.meyouhouse.data.dto.community.DetailImage
import com.likefirst.meyouhouse.databinding.ActivityArticleDetailBinding
import com.likefirst.meyouhouse.ui.BaseActivity

class ArticleDetailActivity :
    BaseActivity<ActivityArticleDetailBinding>(ActivityArticleDetailBinding::inflate) {
    //더미데이터셋
    val DummyDetail = mutableListOf<Comment>(Comment("06/22 03:00", "점점 졸린것이야!"),
        Comment("06/22 03:00", "점점 졸린것이야!"),
        Comment("06/22 03:00", "점점 졸린것이야!"),
        Comment("06/22 03:00", "점점 졸린것이야!"),
        Comment("06/22 03:00", "점점 졸린것이야!"),
        Comment("06/22 03:00", "점점 졸린것이야!"),
        Comment("06/22 03:00", "점점 졸린것이야!"),
        Comment("06/22 03:00", "점점 졸린것이야!"),
        Comment("06/22 03:00", "점점 졸린것이야!"),
        Comment("06/22 03:00", "점점 졸린것이야!"))

    val DummyImages = mutableListOf<DetailImage>(
//        DetailImage("여기에는 사진명", DUMMY_URL),
//        DetailImage("여기에는 사진명", DUMMY_URL),
//        DetailImage("여기에는 사진명", DUMMY_URL),
//        DetailImage("여기에는 사진명", DUMMY_URL)
    )

    private lateinit var commentAdapter: CommentRVAdapter
    private lateinit var detailImageAdapter: DetailImageRVAdapter

    override fun initAfterBinding() {

        // TODO
        // 글 정보를 토대로 댓글에서 세부내용을 긁어옴
        // 아마 이미지를 표현해야하겠지?
        // 이미지 URL 받아서 리사이클러뷰에 넣어주기
        initCommentRV()
        initDetailImageRV()
        initBodyAndDateTextView()
        initCommentSubmitButton()
    }

    private fun initDetailImageRV() {
        detailImageAdapter = DetailImageRVAdapter(DummyImages)
        binding.detailImageRecyclerView.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }
        binding.detailImageRecyclerView.adapter = detailImageAdapter
    }

    private fun initBodyAndDateTextView() {
        binding.detailBodyTextView.text = "여기에 받아온 데이터를 넣으면 되겠다!"
        binding.detailDate.text = "06/22 12:34"
    }

    private fun initCommentRV() {
        commentAdapter = CommentRVAdapter(DummyDetail)
        binding.commentRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.commentRecyclerView.adapter = commentAdapter
    }

    private fun initCommentSubmitButton() {
        // TODO 버튼 클릭시, 서버에 전송, 및 화면 재로딩
    }

    companion object {
        const val DUMMY_URL = "https://www.e2news.com/news/photo/202108/235458_90085_818.jpg"
    }
}