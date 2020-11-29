package com.example.tmdb.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tmdb.ui.home.popular.PopularMoviesFragment
import com.example.tmdb.ui.home.top_rated.TopRatedMoviesFragment

const val NUMBER_OF_TABS = 2

class MoviesViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = NUMBER_OF_TABS

    override fun createFragment(position: Int): Fragment =
        if (position == 0) PopularMoviesFragment() else TopRatedMoviesFragment()
}