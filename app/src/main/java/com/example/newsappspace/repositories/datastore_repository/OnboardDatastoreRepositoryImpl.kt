package com.example.newsappspace.repositories.datastore_repository

import com.example.newsappspace.datastore.CheckUserDataStore

class OnboardDatastoreRepositoryImpl(val dataStore: CheckUserDataStore):OnboardDatastoreRepository {



    override suspend fun saveUserState(key:String,value:Boolean) {
        dataStore.saveState(key,value)    }
}