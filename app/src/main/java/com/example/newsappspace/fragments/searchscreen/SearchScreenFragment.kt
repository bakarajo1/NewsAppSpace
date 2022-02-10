package com.example.newsappspace.fragments.searchscreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappspace.R
import com.example.newsappspace.adapters.OnClickListener
import com.example.newsappspace.adapters.newsAdapter.NewsAdapter
import com.example.newsappspace.basemodels.BaseFrag
import com.example.newsappspace.databinding.NewsScreenFragmentBinding
import com.example.newsappspace.databinding.SearchScreenFragmentBinding
import com.example.newsappspace.fragments.newsscreen.NewsScreenViewModel
import com.example.newsappspace.model.ArticleX

class SearchScreenFragment : BaseFrag<SearchScreenFragmentBinding, SearchScreenViewModel>(),OnClickListener {

    private val myAdapter by lazy { NewsAdapter(this) }

    override val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> SearchScreenFragmentBinding
        get() = SearchScreenFragmentBinding::inflate

    override fun connectViewmodel(): Class<SearchScreenViewModel> = SearchScreenViewModel::class.java


    override fun init() {
        observePrgBar()
        initRecyclerView()
        observeSuccessLiveData()
        setListeners()

    }

    private fun setListeners() {
        with(binding){
            searchInputEditText.addTextChangedListener {
                viewModel.searchSelected(it.toString())
            }
        }
    }

    private fun initRecyclerView() {
        with(binding.searchRecycler) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = myAdapter
            // Toast.makeText(requireContext(), "hello", Toast.LENGTH_SHORT).show()

        }
    }
    private fun observeSuccessLiveData() {
        viewModel.successLiveData.observe(viewLifecycleOwner) {
            myAdapter.submitList(it.articles)
        }
    }
    private fun observePrgBar() {
        viewModel.prgBar.observe(viewLifecycleOwner) {
            if (it){
                binding.progressBar.visibility=View.VISIBLE
            }else{
                binding.progressBar.visibility=View.GONE

            }
        }
    }


    override fun onItemCLick(article: ArticleX) {
        findNavController().navigate(R.id.action_newsScreenFragment_to_newsDetailsFragment)
    }

}