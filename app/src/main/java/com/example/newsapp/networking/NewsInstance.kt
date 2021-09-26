package com.example.newsapp.networking

import androidx.lifecycle.MutableLiveData
import com.example.newsapp.models.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "1e232e6eae24456e9537ce8eece2b8ad"
interface NewsInstance {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    suspend fun getHeadlines(
        @Query("country") country: String,
        @Query("category") category: String
    ): Response<News>
}