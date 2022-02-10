package com.example.newsappspace.repositories.news_screen_repo

import com.example.newsappspace.model.News
import retrofit2.Response

interface NewsRepo {

        suspend fun getNewsByCategory(
            apiKey: String,
            category: String
        ): Response<News>
}