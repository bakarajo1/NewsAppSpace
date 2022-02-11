package com.example.newsappspace.repositories.save_repository

import com.example.newsappspace.database.ArticleDao
import com.example.newsappspace.model.Article

class SaveRepoImpl(private val articleDao: ArticleDao):SaveRepo {
    override suspend fun getAllNews(): List<Article> {
        return  articleDao.getAllNews()
    }
}