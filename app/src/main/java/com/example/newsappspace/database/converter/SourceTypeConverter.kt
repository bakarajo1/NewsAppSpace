package com.example.newsappspace.database.converter

import androidx.room.TypeConverter
import com.example.newsappspace.model.Source

class SourceTypeConverter {
    @TypeConverter
    fun convertToString(source:Source): String? {
        return source.name
    }
    @TypeConverter
    fun convertFromString(name: String):Source{
        return Source(null,name)
    }
}