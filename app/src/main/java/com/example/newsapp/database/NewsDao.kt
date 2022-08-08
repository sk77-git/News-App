package com.example.newsapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.newsapp.model.news.Article

@Dao
interface NewsDao {


    @Insert
    suspend fun addArticles(article: List<Article>)

    @Query("SELECT * FROM articles")
    suspend fun getArticles(): List<Article>
}