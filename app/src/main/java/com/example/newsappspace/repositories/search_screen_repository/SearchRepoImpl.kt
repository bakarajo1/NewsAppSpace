package com.example.newsappspace.repositories.search_screen_repository

import com.example.newsappspace.model.News
import com.example.newsappspace.retrofit.RetrofitService
import retrofit2.Response

class SearchRepoImpl:SearchRepo {
    override suspend fun getSearchedNews(apiKey: String, q: String): Response<News> {
        val response = RetrofitService.apiService.getSearchedNews(apiKey = apiKey, q = q)

        return Response.success(response.body()!!)
    }

}