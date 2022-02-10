package com.example.newsappspace.database.converter

import androidx.room.TypeConverter
import com.example.newsappspace.model.SourceX

class Converter {
    @TypeConverter
    fun convertToString(source:SourceX): String? {
        return source.name
    }
    @TypeConverter
    fun convertFromString(name: String):SourceX{
        return SourceX(null,name)
    }
}