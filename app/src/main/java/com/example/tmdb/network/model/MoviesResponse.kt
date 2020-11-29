package com.example.tmdb.network.model

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("total_results")
    val totalResults: Long,

    @SerializedName("page")
    val page: Long,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("results")
    val results: List<Movie>
)