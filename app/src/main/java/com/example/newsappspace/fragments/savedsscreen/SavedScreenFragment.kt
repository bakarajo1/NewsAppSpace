package com.example.newsappspace.fragments.savedsscreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsappspace.R
import com.example.newsappspace.basemodels.BaseFrag
import com.example.newsappspace.databinding.NewsScreenFragmentBinding
import com.example.newsappspace.databinding.SavedScreenFragmentBinding
import com.example.newsappspace.fragments.newsscreen.NewsScreenViewModel

class SavedScreenFragment : BaseFrag<SavedScreenFragmentBinding, SavedScreenViewModel>() {

    override val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> SavedScreenFragmentBinding
        get() = SavedScreenFragmentBinding::inflate

    override fun connectViewmodel(): Class<SavedScreenViewModel> = SavedScreenViewModel::class.java


    override fun init() {
       // TODO("Not yet implemented")
    }

}

