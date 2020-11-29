package com.example.tmdb.ui.home.popular

import androidx.lifecycle.ViewModelProvider
import com.example.tmdb.core.MoviesViewModelFactory
import com.example.tmdb.ui.home.MoviesFragment

class PopularMoviesFragment : MoviesFragment() {
    private val viewModel by lazy {
        ViewModelProvider(this, MoviesViewModelFactory()).get(
            PopularMoviesViewModel::class.java
        )
    }

    override fun startListeningForMoviesUpdates() {
        viewModel.getPopularMovies().observe(this.viewLifecycleOwner, {
            moviesListAdapter.submitData(lifecycle, it)
        })
    }
}