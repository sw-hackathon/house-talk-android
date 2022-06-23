package com.likefirst.meyouhouse.ui.onboarding.host

import android.content.Intent
import com.likefirst.meyouhouse.databinding.FragmentHostOnboarding2Binding
import com.likefirst.meyouhouse.ui.BaseFragment
import com.likefirst.meyouhouse.ui.main.MainActivity
import com.likefirst.meyouhouse.util.saveJwt

class HostOnboardingFragment2 : BaseFragment<FragmentHostOnboarding2Binding>(
    FragmentHostOnboarding2Binding::inflate
) {
    override fun initAfterBinding() {
        with(binding) {
            btnNext.setOnClickListener {
                activity?.finish()
                saveJwt("host")
                Intent(requireContext(), MainActivity::class.java).also {
                    startActivity(it)
                }
            }
            clPrevious.setOnClickListener {
                activity?.onBackPressed()
            }
        }
    }
}