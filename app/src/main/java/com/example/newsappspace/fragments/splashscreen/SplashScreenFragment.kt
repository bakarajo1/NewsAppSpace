package com.example.newsappspace.fragments.splashscreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.view.ViewCompat.animate
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.newsappspace.R
import com.example.newsappspace.basemodels.BaseFrag
import com.example.newsappspace.databinding.NewsScreenFragmentBinding
import com.example.newsappspace.databinding.SplashScreenFragmentBinding
import com.example.newsappspace.fragments.newsscreen.NewsScreenViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenFragment : BaseFrag<SplashScreenFragmentBinding, SplashScreenViewModel>() {
    var animation: Animation? = null

    override val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> SplashScreenFragmentBinding
        get() = SplashScreenFragmentBinding::inflate

    override fun connectViewmodel(): Class<SplashScreenViewModel> = SplashScreenViewModel::class.java


    override fun init() {


        animater()
        navigate()
    }

    private fun animater() {
        animation = AnimationUtils.loadAnimation(requireContext(), R.anim.abc)
        binding.imageView.startAnimation(animation)

    }

    private fun navigate() {
        lifecycleScope.launch {
            delay(3000L)
            findNavController().navigate(R.id.action_splashScreenFragment_to_viewpagerHost)        }

    }

}