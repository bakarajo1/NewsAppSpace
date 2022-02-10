package com.example.newsappspace.fragments.search_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappspace.model.News
import com.example.newsappspace.repositories.search_screen_repo.SearchRepo
import com.example.newsappspace.repositories.search_screen_repo.SearchRepoImpl
import com.example.newsappspace.retrofit.ApiKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchScreenViewModel : ViewModel() {
    private val repository: SearchRepo by lazy { SearchRepoImpl() }

    private val _successLiveData: MutableLiveData<News> = MutableLiveData()
    val successLiveData: LiveData<News> get() = _successLiveData

    private val _prgBar: MutableLiveData<Boolean> = MutableLiveData()
    val prgBar: LiveData<Boolean> get() = _prgBar





    fun searchSelected(q:String){
        getNews(q)
    }

    private fun getNews(q: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _prgBar.postValue(true)
            val response = repository.getSearchedNews( ApiKey, q = q)

            _successLiveData.postValue(response.body())

            _prgBar.postValue(false)

        }
    }
}