package com.example.newsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.networking.NewsService
import com.example.newsapp.repository.NewsRepository
import com.example.newsapp.viewModel.NewsViewModelFactory
import com.example.newsapp.viewModel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_science.*

class BusinessFragment : Fragment() {

    lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_business, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycleView.layoutManager = LinearLayoutManager(activity)
        adapter = NewsAdapter()
        recycleView.adapter = adapter
        val newsInstance = NewsService.getInstance()
        val newsRepository = NewsRepository(newsInstance)

        val viewModel = ViewModelProvider(this , NewsViewModelFactory(newsRepository)).get(
            NewsViewModel::class.java)
        viewModel.news.observe(viewLifecycleOwner , Observer {
            adapter.setNewsListItems(it)
        })

        viewModel.getNews("in" , "business")
    }

}