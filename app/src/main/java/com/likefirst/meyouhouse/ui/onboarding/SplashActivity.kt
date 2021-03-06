package com.likefirst.meyouhouse.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.likefirst.meyouhouse.R
import com.likefirst.meyouhouse.databinding.ActivitySplashBinding
import com.likefirst.meyouhouse.ui.BaseActivity
import com.likefirst.meyouhouse.ui.main.MainActivity
import com.likefirst.meyouhouse.ui.onboarding.client.ClientOnboardingActivity
import com.likefirst.meyouhouse.ui.onboarding.host.HostOnboardingActivity
import com.likefirst.meyouhouse.util.getJwt

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {
    override fun initAfterBinding() {
        if (!isOnboardingActivated) {
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }

        binding.btnClient.setOnClickListener {
            Intent(this, ClientOnboardingActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }

        binding.btnHost.setOnClickListener {
            Intent(this, HostOnboardingActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }
    }

    private val isOnboardingActivated: Boolean
        get() = getJwt().isNullOrBlank()
}