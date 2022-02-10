package com.example.newsappspace.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newsappspace.database.converter.Converter
import com.example.newsappspace.model.ArticleX

@Database(entities = [ArticleX::class], version = 1)
@TypeConverters(Converter::class)
abstract class NewsDatabase: RoomDatabase() {

    abstract fun newsDao():ArticleDao


    companion object{
        fun buildDatabase(context: Context):NewsDatabase=Room.databaseBuilder(context,NewsDatabase::class.java,"News.db").build()

    }
}