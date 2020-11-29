package com.example.tmdb.ui.home.top_rated

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.tmdb.ui.home.adapter.model.MovieData
import com.example.tmdb.repo.MovieRepository

class TopRatedMoviesViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {
    fun getTopRatedMovies(): LiveData<PagingData<MovieData>> {
        return movieRepository
            .getTopRatedMovies()
            .cachedIn(viewModelScope)
    }
}