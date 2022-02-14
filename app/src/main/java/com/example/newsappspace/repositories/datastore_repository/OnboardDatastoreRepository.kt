package com.example.newsappspace.repositories.datastore_repository

interface OnboardDatastoreRepository {
    suspend fun saveUserState(key:String,value:Boolean)
}