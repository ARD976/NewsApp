package com.example.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.networking.NewsService
import com.example.newsapp.repository.NewsRepository
import com.example.newsapp.viewModel.NewsViewModel
import com.example.newsapp.viewModel.NewsViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel
    lateinit var mAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val newsService = NewsService.getInstance()
        val newsRepository = NewsRepository(newsService)
        recycleView.layoutManager = LinearLayoutManager(this)
        mAdapter = NewsAdapter()
        recycleView.adapter = mAdapter

        viewModel = ViewModelProvider(this, NewsViewModelFactory(newsRepository)).get(NewsViewModel::class.java)


        observeData()

        viewModel.getNews()


    }

    private fun observeData(){
        viewModel.news.observe(this, {
            mAdapter.setNewsListItems(it)

        })
    }

    /*
    private suspend fun fetchNews() {
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
                    mAdapter.setNewsListItems(response.body()!!.articles)
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("MainActivity" , "Error fetching from Internet" , t)
            }

        })
    }

     */

}