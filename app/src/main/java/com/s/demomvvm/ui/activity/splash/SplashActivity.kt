package com.s.demomvvm.ui.activity.splash

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.s.demomvvm.BR
import com.s.demomvvm.R
import com.s.demomvvm.base.BaseActivity
import com.s.demomvvm.databinding.ActivitySplashBinding
import com.s.demomvvm.ui.activity.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {
    @Inject
    lateinit var mSplashViewModel: SplashViewModel
    override fun getBindingVariable(): Int {
        return  BR.spashViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun getViewModel(): SplashViewModel {
        return mSplashViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish()
        }, 2000)
    }
}