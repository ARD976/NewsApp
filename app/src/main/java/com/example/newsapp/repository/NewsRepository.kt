package com.example.newsapp.repository

import com.example.newsapp.networking.NewsInstance
import com.example.newsapp.networking.NewsService

class NewsRepository(private val newsInstance: NewsInstance) {

    suspend fun getNews() = newsInstance.getHeadlines("us" , "science")
}