package com.example.newsappspace

import android.app.Application
import com.example.newsappspace.database.NewsDatabase
import com.example.newsappspace.datastore.CheckUserDataStore

class App :Application(){


    companion object{
        private lateinit var context: App

        val db:NewsDatabase by lazy { NewsDatabase.buildDatabase(context) }
        val dataStore:CheckUserDataStore by lazy {
            CheckUserDataStore(context)
        }

    }


    override fun onCreate() {
        super.onCreate()
        context=this
    }
}