package com.example.newsapp.models

import androidx.lifecycle.MutableLiveData

data class News (
    val status : String ,
    val totalResults : Int ,
    val articles : List<Articles>
        )