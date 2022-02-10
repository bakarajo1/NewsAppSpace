package com.example.newsappspace.fragments.onboarding.oboarding1

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.newsappspace.basemodels.BaseFrag
import com.example.newsappspace.databinding.OnboardingFirstFragmentBinding

class OnboardingFirstFragment : BaseFrag<OnboardingFirstFragmentBinding, OnboardingFirstViewModel>() {

    override val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> OnboardingFirstFragmentBinding
        get() = OnboardingFirstFragmentBinding::inflate

    override fun connectViewmodel(): Class<OnboardingFirstViewModel> = OnboardingFirstViewModel::class.java


    override fun init() {
       // TODO("Not yet implemented")
    }

}