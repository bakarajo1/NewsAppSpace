package com.example.newsappspace.fragments.onboarding.onboarding2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsappspace.databinding.FragmentOnboarding2Binding

class Onboarding2SearchFragment : Fragment() {
    private var _binding: FragmentOnboarding2Binding? =null
    val binding=_binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentOnboarding2Binding.inflate(inflater,container,false)
        return _binding!!.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}