package com.example.newsappspace.fragments.newsdetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsappspace.R
import com.example.newsappspace.basemodels.BaseFrag
import com.example.newsappspace.databinding.NewsDetailsFragmentBinding
import com.example.newsappspace.databinding.NewsScreenFragmentBinding
import com.example.newsappspace.fragments.newsscreen.NewsScreenViewModel

class NewsDetailsFragment: BaseFrag<NewsDetailsFragmentBinding, NewsDetailsViewModel>() {

    override val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> NewsDetailsFragmentBinding
    get() = NewsDetailsFragmentBinding::inflate

    override fun connectViewmodel(): Class<NewsDetailsViewModel> = NewsDetailsViewModel::class.java


    override fun init() {
//        TODO("Not yet implemented")
    }

}