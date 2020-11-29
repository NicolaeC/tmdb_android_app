package com.example.tmdb.network.model

import com.example.tmdb.network.IMAGE_PREFIX
import com.example.tmdb.ui.details.model.MovieDetailsData
import com.google.gson.annotations.SerializedName

data class MovieDetails(
    @SerializedName("adult")
    val adult: Boolean,

    @SerializedName("budget")
    val budget: Long,

    @SerializedName("genres")
    val genres: List<Genre>,

    @SerializedName("homepage")
    val homepage: String,

    @SerializedName("id")
    val id: Long,

    @SerializedName("revenue")
    val revenue: Long,

    @SerializedName("runtime")
    val runtime: Long,

    @SerializedName("status")
    val status: String,

    @SerializedName("tagline")
    val tagline: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("video")
    val video: Boolean,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("popularity")
    val popularity: Double,

    @SerializedName("backdrop_path")
    val backdropPath: String,

    @SerializedName("belongs_to_collection")
    val belongsToCollection: Any? = null,

    @SerializedName("imdb_id")
    val imdbID: String,

    @SerializedName("original_language")
    val originalLanguage: String,

    @SerializedName("original_title")
    val originalTitle: String,

    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>,

    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry>,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,

    @SerializedName("vote_average")
    val voteAverage: Double,

    @SerializedName("vote_count")
    val voteCount: Long
) {
    fun toMovieDetailsData(): MovieDetailsData {
        val genresConcatenated = genres.joinToString(", ") {
            it.name
        }

        return MovieDetailsData(
            "$IMAGE_PREFIX$backdropPath",
            "$IMAGE_PREFIX$posterPath",
            title,
            genresConcatenated,
            releaseDate,
            voteAverage,
            runtime,
            overview
        )
    }
}