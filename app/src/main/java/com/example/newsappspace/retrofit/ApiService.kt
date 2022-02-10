package com.example.newsappspace.retrofit

import com.example.newsappspace.model.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("v2/everything")
    suspend fun getSearchedNews(
        @Query("apiKey") apiKey: String,
        @Query("q") q: String
    ): Response<News>

    @GET("v2/top-headlines")
    suspend fun getCustomCategoryNews(
        @Query("apiKey") apiKey: String,
        @Query("category") category: String
    ): Response<News>



}