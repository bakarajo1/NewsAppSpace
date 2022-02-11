package com.example.newsappspace.fragments.saved_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappspace.R
import com.example.newsappspace.adapters.OnClickListener
import com.example.newsappspace.adapters.news_adapter.NewsAdapter
import com.example.newsappspace.base.BaseFragment
import com.example.newsappspace.databinding.SavedScreenFragmentBinding
import com.example.newsappspace.model.ArticleX

class SavedScreenFragment : BaseFragment<SavedScreenFragmentBinding, SavedScreenViewModel>(),OnClickListener {
    private val myAdapter by lazy { NewsAdapter(this) }

    override val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> SavedScreenFragmentBinding
        get() = SavedScreenFragmentBinding::inflate

    override fun connectViewModel(): Class<SavedScreenViewModel> = SavedScreenViewModel::class.java


    override fun init() {
        observePrgBar()
        initRecyclerView()
        observeRecyclerItems()
    }

    private fun initRecyclerView() {
        with(binding.savedRecycler) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = myAdapter
        }
    }
    private fun observeRecyclerItems() {
        viewModel.savedNewsLiveData.observe(viewLifecycleOwner) {
            myAdapter.submitList(it)
        }
    }
    private fun observePrgBar() {
        viewModel.prgBar.observe(viewLifecycleOwner) {
            binding.progressBar2.isVisible=it
        }
    }
    override fun onItemCLick(article: ArticleX) {
        findNavController().navigate(
            R.id.action_savedScreenFragment_to_newsDetailsFragment,
            Bundle().apply { putParcelable("singleArticle",article) }
        )    }
}




