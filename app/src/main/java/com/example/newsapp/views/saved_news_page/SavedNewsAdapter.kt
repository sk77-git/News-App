package com.example.newsapp.views.saved_news_page

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.model.news.Article

class SavedNewsAdapter(private val context: Context, private val dataList: List<Article>):
    RecyclerView.Adapter<SavedNewsAdapter.SavedNewsVH>() {

    class SavedNewsVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val offlineNewsTitleTv: TextView=itemView.findViewById(R.id.offlineNewsTitleTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedNewsVH {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.single_offline_item,parent,false)
        return SavedNewsVH(view)
    }

    override fun onBindViewHolder(holder: SavedNewsVH, position: Int) {
        val sn= position+1
        holder.offlineNewsTitleTv.setText("$sn.  "+dataList.get(position).title)
        if (dataList==null){
            Log.d("TAG", "onBindViewHolder: No data has been saved yet !!!")
            Toast.makeText(context, "No data has been saved yet !!!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return  dataList.size
    }
}