package com.example.newsapp.networking

import kotlinx.coroutines.GlobalScope
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object NewsService {

    private const val BASE_URL = "https://newsapi.org/"

    fun getInstance() : NewsInstance {
        val retrofit =  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(NewsInstance::class.java)
    }
}