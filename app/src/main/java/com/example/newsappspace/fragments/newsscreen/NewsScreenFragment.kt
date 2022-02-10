package com.example.newsappspace.fragments.newsscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappspace.R
import com.example.newsappspace.adapters.newsAdapter.NewsAdapter
import com.example.newsappspace.adapters.OnClickListener
import com.example.newsappspace.basemodels.BaseFrag
import com.example.newsappspace.databinding.NewsScreenFragmentBinding
import com.example.newsappspace.model.ArticleX



class NewsScreenFragment: BaseFrag<NewsScreenFragmentBinding, NewsScreenViewModel>(),
    OnClickListener {

    private val myAdapter by lazy { NewsAdapter(this) }
   // val mm=ArticleX("dsds","dsd","vcvc","fdfdf",null,"hello","","")


    override val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> NewsScreenFragmentBinding
        get() = NewsScreenFragmentBinding::inflate

    override fun connectViewmodel(): Class<NewsScreenViewModel> = NewsScreenViewModel::class.java


    override fun init() {
        observePrgBar()
        initRecyclerView()
        //myAdapter.submitList(listOf<ArticleX>(mm))
        observeRecyclerItems()
        setListeners()

    }

    private fun setListeners() {
        with(binding){
            categoryBusinessTextView.setOnClickListener {
                viewModel.getNews("business")
            }
            categorySportsTextView.setOnClickListener {
                viewModel.getNews("sport")
            }
            categoryTechTextView.setOnClickListener {
                viewModel.getNews("technology")
            }
        }
    }

    private fun initRecyclerView() {
        with(binding.newsRecycler) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = myAdapter
           // Toast.makeText(requireContext(), "hello", Toast.LENGTH_SHORT).show()

        }
    }
    private fun observeRecyclerItems() {
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


