package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter() : RecyclerView.Adapter<NewsViewHolder>(){

    var articlesList : List<Articles> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int){
        val currentItem = articlesList[position]
        holder.titleView.text = currentItem.title
        holder.author.text = currentItem.author
        Glide.with(holder.itemView.context).load(currentItem.urlToImage).into(holder.image)
    }

    fun setNewsListItems(movieList: List<Articles>){
        this.articlesList = movieList;
        notifyDataSetChanged()
    }


}

class NewsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val titleView = itemView.findViewById<TextView>(R.id.titleView)
    val author = itemView.findViewById<TextView>(R.id.author)
    val image = itemView.findViewById<ImageView>(R.id.image)
}

