package com.example.newsapp.views.dashboard

import android.content.Context
import android.content.Intent
import android.provider.AlarmClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.model.news.Article
import com.example.newsapp.views.detail_paage.DetailActivity

class NewsRcvAdapter(private val context: Context, private val dataList: List<Article>): RecyclerView.Adapter<NewsRcvAdapter.NewsVH>() {



    class NewsVH(itemView: View): RecyclerView.ViewHolder(itemView) {
        val newsIconIv: ImageView= itemView.findViewById(R.id.newsIconIv)
        val newDescTv: TextView= itemView.findViewById(R.id.newsDescTv)
        val newsTitleTv: TextView= itemView.findViewById(R.id.newsTitleTv)
        val singleNewsLl: LinearLayout= itemView.findViewById(R.id.singleNewsLl)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsVH {
        val view: View= LayoutInflater.from(parent.context).inflate(R.layout.single_news,parent,false)

        return NewsVH(view)
    }

    override fun onBindViewHolder(holder: NewsVH, position: Int) {
        holder.newDescTv.text= dataList.get(position).description
        holder.newsTitleTv.text= dataList.get(position).title
        Glide.with(holder.itemView.context).load(dataList.get(position).urlToImage).into(holder.newsIconIv)

        holder.singleNewsLl.setOnClickListener(){

            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("urlToImage", dataList.get(position).urlToImage)
                putExtra("title", dataList.get(position).title)
                putExtra("content", dataList.get(position).content)
            }
            context.startActivity(intent)
        }

}

    override fun getItemCount(): Int {
        return dataList.size
    }
}