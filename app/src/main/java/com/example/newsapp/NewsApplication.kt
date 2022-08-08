package com.example.newsapp

import android.app.Application
import com.example.newsapp.database.NewsDatabase
import com.example.newsapp.network.ApiService
import com.example.newsapp.network.RetrofitHelper
import com.example.newsapp.repository.news.NewsRepository

class NewsApplication: Application() {

    lateinit var newsRepository: NewsRepository

    override fun onCreate() {
        super.onCreate()

        val apiService= RetrofitHelper.getInstance().create(ApiService::class.java)
        val database= NewsDatabase.getDatabase(applicationContext)
        newsRepository= NewsRepository(apiService, database, applicationContext)
    }
}