package com.example.newsapp.repository.news

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.database.NewsDatabase
import com.example.newsapp.model.news.News
import com.example.newsapp.network.ApiService
import com.example.newsapp.utils.NetworkUtils

class NewsRepository(
    private val apiService: ApiService,
    private val newsDatabase: NewsDatabase,
    private val applicationContext: Context
) {
    private val newsMutableLiveData= MutableLiveData<News>()
    val newsLiveData: LiveData<News>
    get() = newsMutableLiveData

    suspend fun getNews(){


        if(NetworkUtils.isInternetAvailable(applicationContext)){
            val result= apiService.getNewsData()
            if (result?.body() != null){
                newsDatabase.newsDao().addArticles(result.body()!!.articles)
                newsMutableLiveData.postValue(result.body())
            }
        }
        else{
            val news= newsDatabase.newsDao().getArticles()
            val newsDummy= News(news, "true",100)
            newsMutableLiveData.postValue(newsDummy)

        }
    }


}