package com.example.tmdb.ui.home.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.tmdb.ui.home.adapter.model.MovieData
import com.example.tmdb.repo.MovieRepository

class PopularMoviesViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {

    fun getPopularMovies(): LiveData<PagingData<MovieData>> {
        return movieRepository
            .getPopularMovies()
            .cachedIn(viewModelScope)
    }
}