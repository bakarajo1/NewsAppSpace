package com.example.newsappspace.repositories.save_repository

import com.example.newsappspace.model.ArticleX

interface SaveRepo  {

    suspend fun getAllNews():List<ArticleX>

}