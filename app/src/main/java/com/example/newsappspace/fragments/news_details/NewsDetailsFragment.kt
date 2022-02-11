package com.example.newsappspace.fragments.news_details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.newsappspace.R
import com.example.newsappspace.base.BaseFragment
import com.example.newsappspace.databinding.NewsDetailsFragmentBinding
import kotlinx.coroutines.launch

class NewsDetailsFragment: BaseFragment<NewsDetailsFragmentBinding, NewsDetailsViewModel>() {

    private val args:NewsDetailsFragmentArgs by navArgs()
    override val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> NewsDetailsFragmentBinding
    get() = NewsDetailsFragmentBinding::inflate

    override fun connectViewModel(): Class<NewsDetailsViewModel> = NewsDetailsViewModel::class.java


    override fun init() {

        setViews()
        observeIcon()
        setListener()
    }

    private fun setViews() {
        viewModel.checkArticle(args.singleArticle.url!!)
        binding.newsDescriptionTextView.text=args.singleArticle.description
        Glide.with(binding.newsImageView).load(args.singleArticle.urlToImage).placeholder(R.drawable.ic_launcher_background).into(binding.newsImageView)
        binding.newsNameTextView.text=args.singleArticle.source?.name
        binding.newsTitleTextView.text=args.singleArticle.title
    }

    private fun setListener() {
        binding.favoriteNewsActionButton.setOnClickListener {
            lifecycleScope.launch {
                if (viewModel.checkSavedArticle(args.singleArticle.url!!)){
                    binding.favoriteNewsActionButton.setImageResource(R.drawable.ic_baseline_favorite_24)
                }else{
                    binding.favoriteNewsActionButton.setImageResource(R.drawable.ic_baseline_delete_24)

                }
            }
            viewModel.determineOperation(args.singleArticle,args.singleArticle.url!!)
        }
    }

    private fun observeIcon() {
        viewModel.backgroundLiveData.observe(viewLifecycleOwner, Observer {
            binding.favoriteNewsActionButton.setImageResource(it)
        })
    }

}