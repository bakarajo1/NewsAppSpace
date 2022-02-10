package com.example.newsappspace.fragments.splash_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.newsappspace.R
import com.example.newsappspace.base.BaseFragment
import com.example.newsappspace.databinding.SplashScreenFragmentBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenFragment : BaseFragment<SplashScreenFragmentBinding, SplashScreenViewModel>() {

    override val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> SplashScreenFragmentBinding
        get() = SplashScreenFragmentBinding::inflate

    override fun connectViewModel(): Class<SplashScreenViewModel> =
        SplashScreenViewModel::class.java

    override fun init() {
        animateLogo()
    }
    private fun animateLogo() {
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.rotate_animation)
        binding.imageView.startAnimation(animation)
        navigate()
    }
    private fun navigate() {
        lifecycleScope.launch {
            delay(3000L)
            findNavController().navigate(R.id.action_splashScreenFragment_to_viewpagerHost)
        }
    }
}