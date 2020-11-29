package com.example.tmdb.network

import com.example.tmdb.network.model.MovieDetails
import com.example.tmdb.network.model.MoviesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val apiKey = "dad8a59d86a2793dda93aa485f7339c1"

interface MovieService {
    @GET("movie/popular?api_key=$apiKey")
    fun getPopularMovies(@Query("page") page: Int): Single<MoviesResponse>

    @GET("movie/top_rated?api_key=$apiKey")
    fun getTopRatedMovies(@Query("page") page: Int): Single<MoviesResponse>

    @GET("movie/{movieId}?api_key=$apiKey")
    fun getMovieDetails(@Path("movieId") movieId: Long): Single<MovieDetails>
}