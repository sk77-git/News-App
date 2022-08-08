package com.example.newsapp.network

import com.example.newsapp.model.news.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/v2/everything")
    suspend fun getNewsData(@Query("q") q: String= "apple", @Query("sortBy") sortBy:String="popularity", @Query("apiKey") apiKey:String="4366941d42f84ce4a251ae00d0c66a75"): Response<News>
}