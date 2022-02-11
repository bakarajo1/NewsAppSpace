package com.example.newsappspace.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsappspace.model.Article

@Dao
interface ArticleDao {
    @Query("SELECT * FROM news")
    suspend fun getAllNews(): List<Article>

    @Query("SELECT url FROM news")
    suspend fun getNewsUrl(): List<String>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articles: Article)

    @Query("DELETE FROM news WHERE url=:url")
    suspend fun deleteArticle(url:String)}