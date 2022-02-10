package com.example.newsappspace.fragments.onboarding.onboarding3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsappspace.R
import com.example.newsappspace.databinding.FragmentOnboarding2Binding
import com.example.newsappspace.databinding.FragmentOnboarding3Binding


class Onboarding3 : Fragment() {
    private var _binding: FragmentOnboarding3Binding? =null
    val binding=_binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentOnboarding3Binding.inflate(inflater,container,false)
        return _binding!!.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}
