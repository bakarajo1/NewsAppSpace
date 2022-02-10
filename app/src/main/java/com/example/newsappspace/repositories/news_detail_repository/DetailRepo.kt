package com.example.newsappspace.repositories.news_detail_repository

import com.example.newsappspace.model.ArticleX

interface DetailRepo {


    suspend fun addNews(articleX: ArticleX)
    suspend fun deleteNews(url: String)
    suspend fun getAllNewsUrl():List<String>
}