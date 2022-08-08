package com.example.newsapp.views.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.NewsApplication
import com.example.newsapp.R
import com.example.newsapp.utils.NetworkUtils
import com.example.newsapp.viewmodel.news.NewsViewModel
import com.example.newsapp.viewmodel.news.NewsViewModelFactory
import com.example.newsapp.views.saved_news_page.SavedActivity

class DashboardActivity : AppCompatActivity() {

    private lateinit var newsViewModel: NewsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val recyclerView: RecyclerView = findViewById(R.id.newsRecyclerView)
        val offlineButton: Button = findViewById(R.id.offlineButton)

        if (NetworkUtils.isInternetAvailable(this)){
            offlineButton.visibility= View.GONE
        }
        else{
            offlineButton.visibility= View.VISIBLE
            recyclerView.visibility= View.GONE
        }

        offlineButton.setOnClickListener(){
            intent = Intent(this, SavedActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "...", Toast.LENGTH_SHORT).show()
        }

        recyclerView.layoutManager= LinearLayoutManager(this)

        val repository= (application as NewsApplication).newsRepository

        newsViewModel= ViewModelProvider(this, NewsViewModelFactory(repository)).get(NewsViewModel::class.java)


        newsViewModel.news.observe(this, Observer{
            Log.d("TAG", "onCreate: "+it)
            recyclerView.adapter= NewsRcvAdapter(this,it.articles)

        })
    }
}