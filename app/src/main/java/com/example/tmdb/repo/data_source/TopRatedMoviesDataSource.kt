package com.example.tmdb.repo.data_source

import androidx.paging.rxjava2.RxPagingSource
import com.example.tmdb.ui.home.adapter.model.MovieData
import com.example.tmdb.network.MovieService
import com.example.tmdb.network.model.MoviesResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class TopRatedMoviesDataSource(private val movieService: MovieService) :
    RxPagingSource<Int, MovieData>() {

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, MovieData>> {
        val page = params.key ?: 1

        return movieService.getTopRatedMovies(page)
            .subscribeOn(Schedulers.io())
            .map { toLoadResult(it, page) }
            .onErrorReturn { LoadResult.Error(it) }
    }

    private fun toLoadResult(data: MoviesResponse, position: Int): LoadResult<Int, MovieData> {
        return LoadResult.Page(
            data = data.results.map { it.toMovieData() },
            prevKey = if (position == 1) null else position - 1,
            nextKey = if (position == data.totalPages) null else position + 1
        )
    }
}