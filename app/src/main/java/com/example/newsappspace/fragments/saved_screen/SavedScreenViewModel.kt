package com.example.newsappspace.fragments.saved_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappspace.App
import com.example.newsappspace.database.ArticleDao
import com.example.newsappspace.model.ArticleX
import com.example.newsappspace.repositories.save_repository.SaveRepo
import com.example.newsappspace.repositories.save_repository.SaveRepoImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SavedScreenViewModel : ViewModel() {
    private val repository: SaveRepo by lazy { SaveRepoImpl(App.db.newsDao()) }

    private val _savedNewsLiveData: MutableLiveData<List<ArticleX>> = MutableLiveData()
    val savedNewsLiveData: LiveData<List<ArticleX>> get() = _savedNewsLiveData

    private val _progressBarLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val prgBar: LiveData<Boolean> get() = _progressBarLiveData


    init {
        getNews()
    }
    fun getNews() {
        viewModelScope.launch(Dispatchers.IO) {
            _progressBarLiveData.postValue(true)
            val response = repository.getAllNews()
            _savedNewsLiveData.postValue(response)
            _progressBarLiveData.postValue(false)

        }
    }

}