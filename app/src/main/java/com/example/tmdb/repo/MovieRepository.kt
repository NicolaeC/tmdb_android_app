package com.example.tmdb.repo

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.tmdb.network.MovieService
import com.example.tmdb.repo.data_source.PopularMoviesDataSource
import com.example.tmdb.repo.data_source.TopRatedMoviesDataSource
import com.example.tmdb.ui.details.model.MovieDetailsData
import com.example.tmdb.ui.home.adapter.model.MovieData
import io.reactivex.Single

open class MovieRepository(
    private val service: MovieService,
    private val popularMoviesDataSource: PopularMoviesDataSource,
    private val topRatedMoviesDataSource: TopRatedMoviesDataSource
) {
    fun getTopRatedMovies(): LiveData<PagingData<MovieData>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 40,
            ),
            pagingSourceFactory = { topRatedMoviesDataSource }
        ).liveData
    }

    fun getPopularMovies(): LiveData<PagingData<MovieData>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 40,
            ),
            pagingSourceFactory = { popularMoviesDataSource }
        ).liveData
    }

    open fun getMovieDetails(movieId: Long): Single<MovieDetailsData> {
        return service.getMovieDetails(movieId).map { it.toMovieDetailsData() }
    }
}