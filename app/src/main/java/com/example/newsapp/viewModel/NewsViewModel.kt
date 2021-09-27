package com.example.newsapp.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.models.Articles
import com.example.newsapp.models.News
import com.example.newsapp.repository.NewsRepository
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel(private val  newsRepository: NewsRepository) : ViewModel() {

    var news = MutableLiveData<List<Articles>>()

    fun getNews(country : String , category : String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = newsRepository.getNews(country,category)
            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    news.value = response.body()!!.articles
                }else{
                    Log.d("Aman" , "Error fetching data")
                }
            }
        }
    }
}