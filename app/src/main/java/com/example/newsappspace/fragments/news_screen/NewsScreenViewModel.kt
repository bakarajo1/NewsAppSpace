package com.example.newsappspace.fragments.news_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappspace.model.News
import com.example.newsappspace.repositories.news_screen_repository.NewsRepo
import com.example.newsappspace.repositories.news_screen_repository.NewsRepoImpl
import com.example.newsappspace.retrofit.ApiKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class NewsScreenViewModel : ViewModel() {
    private val repository: NewsRepo by lazy { NewsRepoImpl() }

    private val _successLiveData: MutableLiveData<News> = MutableLiveData()
    val successLiveData: LiveData<News> get() = _successLiveData

    private val _progressBarLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val prgBar: LiveData<Boolean> get() = _progressBarLiveData




    fun getNews(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _progressBarLiveData.postValue(true)
            val response = repository.getNewsByCategory( ApiKey, category = category)

                 _successLiveData.postValue(response.body())
//
            _progressBarLiveData.postValue(false)

        }
    }


}