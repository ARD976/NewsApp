package com.example.newsapp.networking

import com.example.newsapp.Articles
import com.example.newsapp.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "1e232e6eae24456e9537ce8eece2b8ad"
const val BASE_URL = "https://newsapi.org/"
interface NewsInstance {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country : String , @Query("category") category : String) : Call<News>

}

object NewsService {

    fun getRetrofit() : NewsInstance {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        return retrofit.create(NewsInstance::class.java)
    }
}