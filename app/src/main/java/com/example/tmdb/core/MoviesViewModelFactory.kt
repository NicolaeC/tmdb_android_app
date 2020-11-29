package com.example.tmdb.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdb.network.MovieService
import com.example.tmdb.network.RetrofitClient
import com.example.tmdb.repo.MovieRepository
import com.example.tmdb.ui.details.MovieDetailsViewModel
import com.example.tmdb.ui.home.top_rated.TopRatedMoviesViewModel
import com.example.tmdb.repo.data_source.PopularMoviesDataSource
import com.example.tmdb.ui.home.popular.PopularMoviesViewModel
import com.example.tmdb.repo.data_source.TopRatedMoviesDataSource

class MoviesViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    private var movieRepository: MovieRepository

    init {
        val movieService = RetrofitClient.client.create(MovieService::class.java)
        val popularMoviesDataSource = PopularMoviesDataSource(movieService)
        val topRatedMoviesDataSource = TopRatedMoviesDataSource(movieService)

        movieRepository =
            MovieRepository(movieService, popularMoviesDataSource, topRatedMoviesDataSource)
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(TopRatedMoviesViewModel::class.java) -> TopRatedMoviesViewModel(movieRepository) as T
            modelClass.isAssignableFrom(PopularMoviesViewModel::class.java) -> PopularMoviesViewModel(movieRepository) as T
            modelClass.isAssignableFrom(MovieDetailsViewModel::class.java) -> MovieDetailsViewModel(movieRepository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}