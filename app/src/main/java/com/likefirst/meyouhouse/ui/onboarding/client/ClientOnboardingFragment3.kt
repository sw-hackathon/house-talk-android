package com.likefirst.meyouhouse.ui.onboarding.client

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.likefirst.meyouhouse.R
import com.likefirst.meyouhouse.databinding.FragmentClientOnboarding1Binding
import com.likefirst.meyouhouse.databinding.FragmentClientOnboarding3Binding
import com.likefirst.meyouhouse.ui.BaseFragment
import com.likefirst.meyouhouse.ui.main.MainActivity

class ClientOnboardingFragment3 :
    BaseFragment<FragmentClientOnboarding3Binding>(FragmentClientOnboarding3Binding::inflate) {
    override fun initAfterBinding() {
        binding.btnNext.setOnClickListener {
            activity?.finish()
            Intent(requireContext(), MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}