package com.likefirst.meyouhouse.ui.onboarding.host

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.likefirst.meyouhouse.R
import com.likefirst.meyouhouse.data.remote.auth.PostHomeRequest
import com.likefirst.meyouhouse.databinding.FragmentClientOnboarding2Binding
import com.likefirst.meyouhouse.databinding.FragmentHostOnboarding1Binding
import com.likefirst.meyouhouse.ui.BaseFragment
import com.likefirst.meyouhouse.util.ApplicationClass
import com.likefirst.meyouhouse.util.RetrofitInterface
import com.likefirst.meyouhouse.util.enqueueUtil

class HostOnboardingFragment1 : BaseFragment<FragmentHostOnboarding1Binding>(
    FragmentHostOnboarding1Binding::inflate
) {
    override fun initAfterBinding() {
        with(binding) {
            btnNext.setOnClickListener {
                if (isNextBtnValid) {
                    val name = binding.etInput.text.toString()
                    val postHomeRequest = PostHomeRequest(name= name)
                    ApplicationClass.retrofit.create(RetrofitInterface::class.java).postHome(postHomeRequest).apply {
                        enqueueUtil(
                            onSuccess = {
                                val code = it?.result?.home?.code
                                if(code.isNullOrBlank()) {
                                    Toast.makeText(requireContext(), "서버 통신 오류", Toast.LENGTH_SHORT).show()
                                } else {
                                    val action = HostOnboardingFragment1Directions.actionHostOnboardingFragment1ToHostOnboardingFragment2(code)
                                    findNavController().navigate(action)
                                }
                            },
                            onError = {
                                Toast.makeText(requireContext(), "서버 통신 오류", Toast.LENGTH_SHORT).show()
                            }
                        )
                    }
                }
            }
            clPrevious.setOnClickListener {
                activity?.onBackPressed()
            }
        }
    }

    private val isNextBtnValid: Boolean
        get() = binding.etInput.text.isNotEmpty()

}