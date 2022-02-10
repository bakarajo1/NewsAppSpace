package com.example.newsappspace.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsappspace.model.ArticleX

@Dao
interface ArticleDao {
    @Query("SELECT * FROM news")
    suspend fun getAllNews(): List<ArticleX>

    @Query("SELECT url FROM news")
    suspend fun getNewsUrl(): List<String>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articles: ArticleX)

    @Query("DELETE FROM news WHERE url=:url")
    suspend fun deleteArticle(url:String)}