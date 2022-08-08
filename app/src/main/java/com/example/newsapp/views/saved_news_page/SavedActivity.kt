package com.example.newsapp.views.saved_news_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.NewsApplication
import com.example.newsapp.R
import com.example.newsapp.viewmodel.news.NewsViewModel
import com.example.newsapp.viewmodel.news.NewsViewModelFactory
import com.example.newsapp.views.dashboard.NewsRcvAdapter

class SavedActivity : AppCompatActivity() {
    private lateinit var newsViewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved)

        val recyclerView: RecyclerView= findViewById(R.id.offlineRecycler)
        recyclerView.layoutManager=LinearLayoutManager(this)


        val repository= (application as NewsApplication).newsRepository

        newsViewModel= ViewModelProvider(this, NewsViewModelFactory(repository)).get(NewsViewModel::class.java)


        newsViewModel.news.observe(this, Observer{
            Log.d("TAG", "onCreate: "+it)
            recyclerView.adapter= SavedNewsAdapter(this,it.articles)

        })

    }
}