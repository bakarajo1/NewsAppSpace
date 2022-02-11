package com.example.newsappspace.repositories.save_repository

import com.example.newsappspace.model.Article

interface SaveRepo  {

    suspend fun getAllNews():List<Article>

}