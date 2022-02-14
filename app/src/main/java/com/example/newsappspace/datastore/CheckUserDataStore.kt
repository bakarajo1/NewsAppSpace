package com.example.newsappspace.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.newsappspace.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CheckUserDataStore (context: Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
        name = context.getString(R.string.NAME_NEWS_DATASTORE)
    )
    private val dataStore: DataStore<Preferences> = context.dataStore


    suspend fun saveState(key: String,value:Boolean) {

        dataStore.edit { newsDataStore->
            newsDataStore[stringPreferencesKey(key)] = value.toString()
        }
    }
    fun getState(key: String): Flow<String> {
        val temp= dataStore.data.map { newsDataStore ->
            newsDataStore[stringPreferencesKey(key)] ?: NOT_FOUND
        }
        return temp
    }

    companion object{
        const val NOT_FOUND= "Not Found"
    }
}

