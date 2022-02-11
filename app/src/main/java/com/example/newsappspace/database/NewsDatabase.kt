package com.example.newsappspace.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newsappspace.database.converter.SourceTypeConverter
import com.example.newsappspace.model.Article

@Database(entities = [Article::class], version = 1)
@TypeConverters(SourceTypeConverter::class)
abstract class NewsDatabase: RoomDatabase() {

    abstract fun newsDao():ArticleDao


    companion object{
        fun buildDatabase(context: Context):NewsDatabase=Room.databaseBuilder(context,NewsDatabase::class.java,"News.db").build()

    }
}