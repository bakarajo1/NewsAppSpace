package com.example.newsappspace.repositories.searchscreen

import com.example.newsappspace.model.News
import retrofit2.Response

interface SearchRepo {

    suspend fun getSearchedNews(
        apiKey: String,
        q: String
    ): Response<News>


}