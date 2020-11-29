package com.example.tmdb.network.model

import com.google.gson.annotations.SerializedName

data class ProductionCompany(
    @SerializedName("id")
    val id: Long,

    @SerializedName("logo_path")
    val logoPath: String? = null,

    @SerializedName("name")
    val name: String,

    @SerializedName("origin_country")
    val originCountry: String
)