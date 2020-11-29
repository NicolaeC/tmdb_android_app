package com.example.tmdb.ui.details.model

data class MovieDetailsData(
    val backdropUrl: String,
    val posterUrl: String,
    val title: String,
    val genres: String,
    val releaseDate: String,
    val rating: Double,
    val runtime: Long,
    val summary: String
)