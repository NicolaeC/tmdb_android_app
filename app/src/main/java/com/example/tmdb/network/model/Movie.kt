package com.example.tmdb.network.model

import android.annotation.SuppressLint
import com.example.tmdb.network.IMAGE_PREFIX
import com.example.tmdb.ui.home.adapter.model.MovieData
import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("title")
    val title: String,

    @SerializedName("popularity")
    val popularity: Double,

    @SerializedName("adult")
    val adult: Boolean,

    @SerializedName("video")
    val video: Boolean,

    @SerializedName("id")
    val id: Long,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("original_title")
    val originalTitle: String,

    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("vote_average")
    val voteAverage: Double,

    @SerializedName("vote_count")
    val voteCount: Long,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("genre_ids")
    val genreIDS: List<Long>,

    @SerializedName("backdrop_path")
    val backdropPath: String,

    @SerializedName("original_language")
    val originalLanguage: String
) {
    @SuppressLint("NewApi")
    fun toMovieData(): MovieData {
        return MovieData(
            id,
            title,
            "$IMAGE_PREFIX$posterPath",
            voteAverage,
            releaseDate.split("-").firstOrNull() ?: ""
        )
    }
}