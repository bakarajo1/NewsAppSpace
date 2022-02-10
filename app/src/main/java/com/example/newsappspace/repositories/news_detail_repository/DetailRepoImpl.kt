package com.example.newsappspace.repositories.news_detail_repository

import com.example.newsappspace.database.ArticleDao
import com.example.newsappspace.model.ArticleX

class DetailRepoImpl(private val articleDao: ArticleDao):DetailRepo {
    override suspend fun addNews(articleX: ArticleX) {
        articleDao.insertArticles(articleX)
    }

    override suspend fun deleteNews(url: String) {

        articleDao.deleteArticle(url)
    }

    override suspend fun getAllNewsUrl(): List<String> {
        return articleDao.getNewsUrl()
    }
}