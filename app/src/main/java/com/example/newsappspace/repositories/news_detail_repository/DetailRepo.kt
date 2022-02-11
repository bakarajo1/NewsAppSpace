package com.example.newsappspace.repositories.news_detail_repository

import com.example.newsappspace.model.Article

interface DetailRepo {


    suspend fun addNews(article: Article)
    suspend fun deleteNews(url: String)
    suspend fun getAllNewsUrl():List<String>
}