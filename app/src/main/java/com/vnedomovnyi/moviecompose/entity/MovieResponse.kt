package com.vnedomovnyi.moviecompose.entity

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("Search") val movies: List<Movie>?
)