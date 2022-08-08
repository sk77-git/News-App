package com.example.newsapp.viewmodel.news

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.model.news.News
import com.example.newsapp.repository.news.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository): ViewModel() {

    init {
        viewModelScope.launch {
            newsRepository.getNews()
        }
    }

    val news: LiveData<News>
    get() = newsRepository.newsLiveData
}