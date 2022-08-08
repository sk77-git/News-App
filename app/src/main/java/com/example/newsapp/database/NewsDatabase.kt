package com.example.newsapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newsapp.MyConverter
import com.example.newsapp.model.news.Article


@Database(entities = [Article::class], version = 1)

abstract  class NewsDatabase: RoomDatabase() {

    abstract fun newsDao(): NewsDao

    companion object{
        @Volatile
        private var INSTANCE: NewsDatabase?=null
        fun getDatabase(context: Context): NewsDatabase{
            if (INSTANCE==null){
                synchronized(this){
                    INSTANCE= Room.databaseBuilder(context, NewsDatabase::class.java, "articlesDB").build()
                }
            }
            return INSTANCE!!

        }
    }

}