package com.example.newsappspace.fragments.news_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappspace.R
import com.example.newsappspace.adapters.news_adapter.NewsAdapter
import com.example.newsappspace.adapters.OnClickListener
import com.example.newsappspace.base.BaseFragment
import com.example.newsappspace.databinding.NewsScreenFragmentBinding
import com.example.newsappspace.model.Article



class NewsScreenFragment: BaseFragment<NewsScreenFragmentBinding, NewsScreenViewModel>(), OnClickListener {
    private val newsItemAdapter by lazy { NewsAdapter(this) }
    override val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> NewsScreenFragmentBinding
        get() = NewsScreenFragmentBinding::inflate

    override fun connectViewModel(): Class<NewsScreenViewModel> = NewsScreenViewModel::class.java
    override fun init() {
        viewModel.getNews(getString(R.string.category_business))
        observePrgBar()
        initRecyclerView()
        observeRecyclerItems()
        setListeners()
    }
    private fun setListeners() {
        with(binding){
            categoryBusinessTextView.setOnClickListener {
                viewModel.getNews(getString(R.string.category_BUSINESS))
            }
            categorySportsTextView.setOnClickListener {
                viewModel.getNews(getString(R.string.category_SPORT))
            }
            categoryTechTextView.setOnClickListener {
                viewModel.getNews(getString(R.string.category_TECHNOLOGY))
            }
        }
    }

    private fun initRecyclerView() {
        with(binding.newsRecycler) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = newsItemAdapter
        }
    }
    private fun observeRecyclerItems() {
        viewModel.successLiveData.observe(viewLifecycleOwner) {
            newsItemAdapter.submitList(it.articles)
        }
    }
    private fun observePrgBar() {

        viewModel.prgBar.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible=it

        }
    }
    override fun onItemCLick(article: Article) {
        findNavController().navigate(R.id.action_newsScreenFragment_to_newsDetailsFragment,
            Bundle().apply { putParcelable(getString(R.string.SINGLE_ARTICLE),article) }
        )    }
}


