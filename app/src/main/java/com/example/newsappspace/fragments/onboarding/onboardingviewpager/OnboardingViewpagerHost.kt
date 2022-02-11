package com.example.newsappspace.fragments.onboarding.onboardingviewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.newsappspace.R
import com.example.newsappspace.adapters.viewpager_adapter.ViewPagerAdapter
import com.example.newsappspace.base.BaseFragment
import com.example.newsappspace.databinding.ViewpagerHostFragmentBinding

class OnboardingViewpagerHost : BaseFragment<ViewpagerHostFragmentBinding, OnboardingViewpagerHostViewModel>() {

    private lateinit var onboardingViewpager: ViewPager2
    private lateinit var onboardingFragmentsAdapter: ViewPagerAdapter
    private lateinit var navController: NavController
    private var screenPos=0

    override val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> ViewpagerHostFragmentBinding
        get() = ViewpagerHostFragmentBinding::inflate

    override fun connectViewModel(): Class<OnboardingViewpagerHostViewModel> =
        OnboardingViewpagerHostViewModel::class.java


    override fun init() {
        onboardingViewpager=binding.viewPager
        onboardingFragmentsAdapter=ViewPagerAdapter(this)
        onboardingViewpager.adapter=onboardingFragmentsAdapter
        navController = this.findNavController()
        setlistener()
    }

    private fun setlistener() {
        binding.nextTextView.setOnClickListener {
            onboardingViewpager.setCurrentItem(++screenPos,true)
            if (screenPos==3){
                findNavController().navigate(R.id.action_viewpagerHost_to_newsScreenFragment)

            }else if(screenPos==2){
                binding.nextTextView.text=getString(R.string.FINISH)
            }
        }
    }



}