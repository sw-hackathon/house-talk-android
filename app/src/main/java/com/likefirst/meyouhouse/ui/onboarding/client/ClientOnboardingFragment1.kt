package com.likefirst.meyouhouse.ui.onboarding.client

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.likefirst.meyouhouse.R
import com.likefirst.meyouhouse.databinding.FragmentClientOnboarding1Binding
import com.likefirst.meyouhouse.ui.BaseFragment
import com.likefirst.meyouhouse.util.ApplicationClass
import com.likefirst.meyouhouse.util.RetrofitInterface
import com.likefirst.meyouhouse.util.enqueueUtil

class ClientOnboardingFragment1 :
    BaseFragment<FragmentClientOnboarding1Binding>(FragmentClientOnboarding1Binding::inflate) {
    override fun initAfterBinding() {
        with(binding) {
            btnNext.setOnClickListener {
                if (isNextBtnValid) {
                    val code = binding.etCode.text.toString()
                    ApplicationClass.retrofit.create(RetrofitInterface::class.java)
                        .getHomeByCode(code).apply {
                        enqueueUtil(
                            onSuccess = {
                                val home = it?.name
                                val action = ClientOnboardingFragment1Directions.actionClientOnboardingFragment1ToClientOnboardingFragment2(home)
                                findNavController().navigate(action)
                            },
                            onError = {
                                Toast.makeText(requireContext(), "잘못된 코드입니다.", Toast.LENGTH_SHORT)
                                    .show()
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
        get() = binding.etCode.text.isNotEmpty()


}