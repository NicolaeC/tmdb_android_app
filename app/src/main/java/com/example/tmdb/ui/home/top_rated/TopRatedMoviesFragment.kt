package com.example.tmdb.ui.home.top_rated

import androidx.lifecycle.ViewModelProvider
import com.example.tmdb.core.MoviesViewModelFactory
import com.example.tmdb.ui.home.MoviesFragment

class TopRatedMoviesFragment : MoviesFragment() {
    private val viewModel by lazy {
        ViewModelProvider(this, MoviesViewModelFactory()).get(
            TopRatedMoviesViewModel::class.java
        )
    }

    override fun startListeningForMoviesUpdates() {
        viewModel.getTopRatedMovies().observe(viewLifecycleOwner, {
            moviesListAdapter.submitData(lifecycle, it)
        })
    }
}