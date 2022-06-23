package com.likefirst.meyouhouse.ui.onboarding.client

import androidx.navigation.fragment.findNavController
import com.likefirst.meyouhouse.R
import com.likefirst.meyouhouse.databinding.FragmentClientOnboarding2Binding
import com.likefirst.meyouhouse.ui.BaseFragment

class ClientOnboardingFragment2 : BaseFragment<FragmentClientOnboarding2Binding>(
    FragmentClientOnboarding2Binding::inflate
) {
    override fun initAfterBinding() {
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_clientOnboardingFragment2_to_clientOnboardingFragment3)
        }
    }
}