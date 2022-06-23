package com.likefirst.meyouhouse.ui.onboarding.host

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.likefirst.meyouhouse.R
import com.likefirst.meyouhouse.databinding.FragmentClientOnboarding2Binding
import com.likefirst.meyouhouse.databinding.FragmentHostOnboarding1Binding
import com.likefirst.meyouhouse.ui.BaseFragment

class HostOnboardingFragment1 : BaseFragment<FragmentHostOnboarding1Binding>(
    FragmentHostOnboarding1Binding::inflate
) {
    override fun initAfterBinding() {
        with(binding) {
            btnNext.setOnClickListener {
                findNavController().navigate(R.id.action_hostOnboardingFragment1_to_hostOnboardingFragment2)
            }
            clPrevious.setOnClickListener {
                activity?.onBackPressed()
            }
        }
    }
}