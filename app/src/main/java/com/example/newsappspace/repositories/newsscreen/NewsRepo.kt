package com.example.newsappspace.repositories.newsscreen

import com.example.newsappspace.model.News
import retrofit2.Response

interface NewsRepo {

        suspend fun getNewsByCategory(
            apiKey: String,
            category: String
        ): Response<News>

}