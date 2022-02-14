package com.example.newsappspace.fragments.splash_screen

import SplashScreenRepository
import SplashScreenRepositoryImpl
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappspace.App
import com.example.newsappspace.util.Strings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


class SplashScreenViewModel : ViewModel() {

    private val repository: SplashScreenRepository by lazy { SplashScreenRepositoryImpl(App.dataStore) }

    private val _userStateLiveData: MutableLiveData<String> = MutableLiveData()
    val userStateLiveData: LiveData<String> = _userStateLiveData

    init {
        getUserState()
    }
    private fun getUserState() {
        viewModelScope.launch(Dispatchers.IO) {
            _userStateLiveData.postValue(repository.getUserState(Strings.STATE_LOGGED_IN).first())
        }
    }
}