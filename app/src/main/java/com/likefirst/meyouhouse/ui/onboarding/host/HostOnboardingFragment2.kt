package com.likefirst.meyouhouse.ui.onboarding.host

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.fragment.navArgs
import com.likefirst.meyouhouse.databinding.FragmentHostOnboarding2Binding
import com.likefirst.meyouhouse.ui.BaseFragment
import com.likefirst.meyouhouse.ui.main.MainActivity
import com.likefirst.meyouhouse.util.saveJwt

class HostOnboardingFragment2 : BaseFragment<FragmentHostOnboarding2Binding>(
    FragmentHostOnboarding2Binding::inflate
) {
    val args: HostOnboardingFragment2Args by navArgs()
    override fun initAfterBinding() {
        with(binding) {
            btnCode.text = args.code
            btnCopy.setOnClickListener {
//                val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
//                val clip: ClipData = ClipData.newPlainText("CODE", args.code)
//                clipboard.setPrimaryClip(clip)
                Toast.makeText(requireContext(), "코드 복사 완료", Toast.LENGTH_SHORT).show()
            }
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