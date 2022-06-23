package com.likefirst.meyouhouse.ui.onboarding.client

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.likefirst.meyouhouse.R
import com.likefirst.meyouhouse.databinding.FragmentClientOnboarding1Binding
import com.likefirst.meyouhouse.databinding.FragmentClientOnboarding3Binding
import com.likefirst.meyouhouse.ui.BaseFragment
import com.likefirst.meyouhouse.ui.main.MainActivity
import com.likefirst.meyouhouse.util.saveJwt

class ClientOnboardingFragment3 :
    BaseFragment<FragmentClientOnboarding3Binding>(FragmentClientOnboarding3Binding::inflate) {
    override fun initAfterBinding() {
        with(binding) {
            btnNext.setOnClickListener {
                if (isNextBtnValid) {
                    activity?.finish()
                    saveJwt("client")
                    Intent(requireContext(), MainActivity::class.java).also {
                        startActivity(it)
                    }
                } else {
                    Toast.makeText(requireContext(), "호수를 입력해주세요!", Toast.LENGTH_SHORT).show()
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