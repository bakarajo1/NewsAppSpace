package com.example.newsappspace.fragments.onboarding.onboarding_view_pager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappspace.App
import com.example.newsappspace.repositories.datastore_repository.OnboardDatastoreRepositoryImpl
import com.example.newsappspace.util.Strings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OnboardingViewpagerHostViewModel : ViewModel() {
    private val repository=OnboardDatastoreRepositoryImpl(App.dataStore)

    fun saveUserState() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveUserState(Strings.STATE_LOGGED_IN, true)
        }
    }

    }