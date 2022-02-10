package com.example.newsappspace.repositories.news_screen_repo

import com.example.newsappspace.model.News
import com.example.newsappspace.retrofit.RetrofitService.apiService
import retrofit2.Response

class NewsRepoImpl:NewsRepo {
    override suspend fun getNewsByCategory(apiKey: String, category: String): Response<News> {
        val response = apiService.getCustomCategoryNews(apiKey = apiKey, category = category)

        return Response.success(response.body()!!)
    }
}