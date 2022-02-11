package com.example.newsappspace.fragments.news_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappspace.App
import com.example.newsappspace.R
import com.example.newsappspace.model.Article
import com.example.newsappspace.repositories.news_detail_repository.DetailRepo
import com.example.newsappspace.repositories.news_detail_repository.DetailRepoImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsDetailsViewModel : ViewModel() {
        private val repository: DetailRepo by lazy { DetailRepoImpl(App.db.newsDao()) }

        private val _backgroundLiveData: MutableLiveData<Int> = MutableLiveData()
        val backgroundLiveData: LiveData<Int> = _backgroundLiveData

        suspend fun checkSavedArticle(url: String): Boolean = url in repository.getAllNewsUrl()

        fun determineOperation(articles: Article, url: String) {
            viewModelScope.launch {
                if (checkSavedArticle(url)) {
                    deleteArticles(url)
                } else {
                    insertArticle(articles)
                }
            }
        }

        private suspend fun insertArticle(articles: Article) {
            repository.addNews(articles)
        }

        private suspend fun deleteArticles(url: String) {
            repository.deleteNews(url)
        }

        fun checkArticle(url: String) {
            viewModelScope.launch(Dispatchers.IO) {
                if (checkSavedArticle(url)) {
                    _backgroundLiveData.postValue(R.drawable.ic_baseline_delete_24)
                } else {
                    _backgroundLiveData.postValue(R.drawable.ic_baseline_favorite_24)
                }
            }
        }
    }