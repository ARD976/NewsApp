package com.example.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.newsapp.R
import com.example.newsapp.networking.NewsService
import com.example.newsapp.repository.NewsRepository
import com.example.newsapp.utils.NewsPagerAdapter
import com.example.newsapp.viewModel.NewsViewModelFactory
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabList = listOf("Business" , "Science" , "Sports" , "Technology")

        val list = ArrayList<Fragment>()
        list.add(BusinessFragment())
        list.add(ScienceFragment())
        list.add(SportsFragment())
        list.add(TechFragment())

        viewPager.adapter = NewsPagerAdapter(supportFragmentManager , lifecycle , list)
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = tabList[position]
        }.attach()

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}