package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.networking.NewsService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleView.layoutManager = LinearLayoutManager(this)
        adapter = NewsAdapter()
        fetchNews()
        recycleView.adapter = adapter

    }

    private fun fetchNews() {
        val news = NewsService.getRetrofit().getHeadlines("us" , "business")
        news.enqueue(object : Callback<News>{
            /*
            override fun onResponse(call: Call<List<Articles>>?, response: Response<List<Articles>>?) {
                if(response?.body() != null)
                    adapter.setNewsListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<Articles>>, t: Throwable) {
                Log.d("MainActivity" , "Error while connecting to internet" , t)
            }

             */

            override fun onResponse(call: Call<News>, response: Response<News>) {
                if(response.body() != null){
                    adapter.setNewsListItems(response.body()!!.articles)
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("MainActivity" , "Error fetching from Internet" , t)
            }

        })
    }

}