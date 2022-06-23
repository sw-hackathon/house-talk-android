package com.likefirst.meyouhouse.ui.community

import android.content.ClipData
import android.content.Intent
import android.util.Log
import com.likefirst.meyouhouse.databinding.ActivityArticlePostingBinding
import com.likefirst.meyouhouse.databinding.FragmentCommunityBinding
import com.likefirst.meyouhouse.ui.BaseActivity
import com.likefirst.meyouhouse.ui.BaseFragment
import android.graphics.BitmapFactory

import android.graphics.Bitmap
import android.net.Uri
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import com.likefirst.meyouhouse.data.dto.community.SelectedImage
import java.io.FileNotFoundException


class ArticlePostingActivity :
    BaseActivity<ActivityArticlePostingBinding>(ActivityArticlePostingBinding::inflate) {
    override fun initAfterBinding() {
        initSelectedImageRV()
        initPhotoButton()
        initSubmitButton()
        initCancelButton()
    }


    private val selectedImageList = mutableListOf<SelectedImage>()
    private lateinit var selectedImageAdapter : SelectedImageRVAdapter

    private fun initPhotoButton() {
        binding.selectPhotoButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                addCategory(Intent.CATEGORY_OPENABLE)
                putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
                type = "image/*"
            }
            startActivityForResult(intent, READ_REQUEST_CODE)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == READ_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                //선택된 이미지 리스트 초기화
                    selectedImageList.clear()
                if (data == null) return
                val clipData = data.getClipData()
                if (clipData == null) {
                    Log.d(TAG, "한장일때" + data.data.toString())
                    selectedImageList.add(SelectedImage("img1",data.data.toString().toUri()))
                    selectedImageAdapter.setData(selectedImageList)
                    binding.selectedImageCountTextView.text = "${1}/5"
                } else{
                    if (clipData.itemCount > 5) {
                        showToast("사진은 5장까지만 등록가능해요")
                    } else {
                        Log.d(TAG, clipData.itemCount.toString())
                        for (i in 0 until clipData.itemCount) {
                            val imageSingleUri = clipData.getItemAt(i).uri
                            selectedImageList.add(SelectedImage("img${i+1}",imageSingleUri))
                            Log.d(TAG, "${i}장일때" + imageSingleUri.toString())
                        }
                        selectedImageAdapter.setData(selectedImageList)
                        binding.selectedImageCountTextView.text = "${clipData.itemCount}/5"
                    }
                }
            }
        }
    }

    private fun initSelectedImageRV() {
        val initList = mutableListOf<SelectedImage>()
        selectedImageAdapter = SelectedImageRVAdapter(initList)
        binding.selectedPhotoRecyclerView.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }
        binding.selectedPhotoRecyclerView.adapter = selectedImageAdapter
    }

    private fun initSubmitButton() {
        //TODO 서버에 이미지 업로드
        binding.submitTextButton.setOnClickListener {
            //TODO 글내용 + 이미지 보내기
            val userId = 2
            val homeId = 1
            val content = binding.bodyEditText.text.toString()
        }
    }

    private fun initCancelButton() {
        binding.cancelTextButton.setOnClickListener {
            selectedImageList.clear()
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        selectedImageList.clear()
        Log.d(TAG,"onDestoryed! list be cleard")
    }


    companion object {
        const val READ_REQUEST_CODE = 1000
        const val TAG = "ArticlePostAv"
    }
}