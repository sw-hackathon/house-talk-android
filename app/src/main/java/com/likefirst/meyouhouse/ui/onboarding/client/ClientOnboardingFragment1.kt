package com.likefirst.meyouhouse.ui.onboarding.client

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.likefirst.meyouhouse.R
import com.likefirst.meyouhouse.databinding.FragmentClientOnboarding1Binding
import com.likefirst.meyouhouse.ui.BaseFragment

class ClientOnboardingFragment1 :
    BaseFragment<FragmentClientOnboarding1Binding>(FragmentClientOnboarding1Binding::inflate) {
    override fun initAfterBinding() {
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_clientOnboardingFragment1_to_clientOnboardingFragment2)
        }
    }
}