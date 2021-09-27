package com.example.newsapp.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsapp.ui.BusinessFragment
import com.example.newsapp.ui.ScienceFragment
import com.example.newsapp.ui.SportsFragment
import com.example.newsapp.ui.TechFragment
/*
class NewsPagerAdapter(private val fragmentActivity: FragmentActivity , val list : ArrayList<Fragment>): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }

}

 */

class NewsPagerAdapter(private val fragmentManager: FragmentManager, lifecycle: Lifecycle, private val list : ArrayList<Fragment>): FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }

}