package com.example.newsappspace.fragments.search_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappspace.R
import com.example.newsappspace.adapters.OnClickListener
import com.example.newsappspace.adapters.news_adapter.NewsAdapter
import com.example.newsappspace.base.BaseFragment
import com.example.newsappspace.databinding.SearchScreenFragmentBinding
import com.example.newsappspace.fragments.news_screen.NewsScreenFragmentDirections
import com.example.newsappspace.model.ArticleX

class SearchScreenFragment : BaseFragment<SearchScreenFragmentBinding, SearchScreenViewModel>(),
    OnClickListener {

    private val myAdapter by lazy { NewsAdapter(this) }

    override val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> SearchScreenFragmentBinding
        get() = SearchScreenFragmentBinding::inflate

    override fun connectViewModel(): Class<SearchScreenViewModel> =
        SearchScreenViewModel::class.java


    override fun init() {
        observePrgBar()
        initRecyclerView()
        observeSuccessLiveData()
        setListeners()
    }

    private fun setListeners() {
        with(binding) {
            searchInputEditText.addTextChangedListener {
                viewModel.searchSelected(it.toString())
            }
        }
    }

    private fun initRecyclerView() {
        with(binding.searchRecycler) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = myAdapter
        }
    }

    private fun observeSuccessLiveData() {
        viewModel.successLiveData.observe(viewLifecycleOwner) {
            myAdapter.submitList(it.articles)
        }
    }

    private fun observePrgBar() {
        viewModel.prgBar.observe(viewLifecycleOwner) {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    override fun onItemCLick(article: ArticleX) {
        findNavController().navigate(R.id.action_searchScreenFragment_to_newsDetailsFragment,
            Bundle().apply { putParcelable("singleArticle",article) }
        )
    //  SearchScreenFragmentDirections.actionSearchScreenFragmentToNewsDetailsFragment(article)
    }
}