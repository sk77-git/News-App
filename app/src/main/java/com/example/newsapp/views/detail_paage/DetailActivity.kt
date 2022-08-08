package com.example.newsapp.views.detail_paage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.newsapp.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle: Bundle? = intent.extras
        val urlToImage= bundle?.get("urlToImage")
        val title= bundle?.get("title")
        val content= bundle?.get("content")

        val detailIV: ImageView= findViewById(R.id.detailIV)
        val detailTitleTv: TextView= findViewById(R.id.detailTitleTv)
        val detailContentTv: TextView= findViewById(R.id.detailContentTv)

        Glide.with(this).load(urlToImage).into(detailIV)
        detailTitleTv.text=title.toString()
        detailContentTv.text=content.toString()


    }
}