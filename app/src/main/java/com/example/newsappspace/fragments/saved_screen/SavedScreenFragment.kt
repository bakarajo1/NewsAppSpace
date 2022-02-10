package com.example.newsappspace.fragments.saved_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.newsappspace.base.BaseFragment
import com.example.newsappspace.databinding.SavedScreenFragmentBinding

class SavedScreenFragment : BaseFragment<SavedScreenFragmentBinding, SavedScreenViewModel>() {

    override val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> SavedScreenFragmentBinding
        get() = SavedScreenFragmentBinding::inflate

    override fun connectViewModel(): Class<SavedScreenViewModel> = SavedScreenViewModel::class.java


    override fun init() {
       // TODO("Not yet implemented")
    }

}

