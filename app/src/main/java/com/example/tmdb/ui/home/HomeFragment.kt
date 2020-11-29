package com.example.tmdb.ui.home

import android.os.Bundle
import android.view.View
import com.example.tmdb.BaseFragment
import com.example.tmdb.R
import com.example.tmdb.ui.home.adapter.MoviesViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {
    override fun getLayoutResId(): Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureTabLayoutWithViewPager(view)
    }

    private fun configureTabLayoutWithViewPager(view: View) {
        viewPager.adapter = MoviesViewPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getString(if (position == 0) R.string.popular else R.string.top_rated)
        }.attach()
    }
}