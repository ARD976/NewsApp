package com.example.newsapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.repository.NewsRepository

class NewsViewModelFactory(val newsRepository: NewsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            NewsViewModel(this.newsRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}