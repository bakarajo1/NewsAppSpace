package com.example.newsappspace.fragments.onboarding.oboarding1Explore

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.newsappspace.base.BaseFragment
import com.example.newsappspace.databinding.OnboardingFirstFragmentBinding

class Onboarding1ExploreFragment : BaseFragment<OnboardingFirstFragmentBinding, OnboardingFirstViewModel>() {

    override val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> OnboardingFirstFragmentBinding
        get() = OnboardingFirstFragmentBinding::inflate

    override fun connectViewModel(): Class<OnboardingFirstViewModel> = OnboardingFirstViewModel::class.java

    override fun init() {
       // TODO("Not yet implemented")
    }

}