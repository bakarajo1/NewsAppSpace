package com.example.newsappspace.repositories.news_detail_repository

import com.example.newsappspace.database.ArticleDao
import com.example.newsappspace.model.Article

class DetailRepoImpl(private val articleDao: ArticleDao):DetailRepo {
    override suspend fun addNews(article: Article) {
        articleDao.insertArticles(article)
    }

    override suspend fun deleteNews(url: String) {

        articleDao.deleteArticle(url)
    }

    override suspend fun getAllNewsUrl(): List<String> {
        return articleDao.getNewsUrl()
    }
}