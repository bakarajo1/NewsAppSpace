package com.example.newsappspace.repositories.search_screen_repo

import com.example.newsappspace.model.News
import retrofit2.Response

interface SearchRepo {

    suspend fun getSearchedNews(
        apiKey: String,
        q: String
    ): Response<News>


}