package com.example.newsapp.model.news

import androidx.room.Entity

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)