package com.example.newsappspace

import android.app.Application
import com.example.newsappspace.database.NewsDatabase

class App :Application(){


    companion object{
        private lateinit var context: App
        val db:NewsDatabase by lazy { NewsDatabase.buildDatabase(context) }
    }
    override fun onCreate() {
        super.onCreate()
        context=this
    }
}