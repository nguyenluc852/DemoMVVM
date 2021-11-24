package com.s.demomvvm.ui.activity.main


import android.content.Context
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.s.demomvvm.BR
import com.s.demomvvm.R
import com.s.demomvvm.base.BaseActivity
import com.s.demomvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {
    @Inject
    lateinit var mActivityMainViewModel: MainActivityViewModel
    private lateinit var mActivityMainBinding: ActivityMainBinding
    private lateinit var mContext: Context
    lateinit var navController: NavController
    override fun getBindingVariable(): Int {
        return BR.mainActivityViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): MainActivityViewModel {
        return mActivityMainViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        mActivityMainBinding = getViewDataBinding()
        setupFragment()
    }

    private fun setupFragment() {
//        navController = Navigation.findNavController(this, R.id.container)

    }

}