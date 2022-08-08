package com.example.newsapp

import androidx.room.TypeConverter
import com.example.newsapp.model.news.Source
import com.google.gson.Gson

class MyConverter {
    companion object {
        @TypeConverter
        @JvmStatic
        fun fromSource(value: Source): String {
            return value.toString()
        }

        @TypeConverter
        @JvmStatic
        fun toSource(value: Source): String {
            val gson= Gson()
            return gson.toJson(value)
        }
    }
}