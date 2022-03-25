package com.vnedomovnyi.moviecompose.entity

import com.google.gson.annotations.SerializedName

data class MovieDetails(
    @SerializedName("imdbID") val id: String,
    @SerializedName("Title") val title: String,
    @SerializedName("Poster") val posterUrl: String,
    @SerializedName("Plot") val plot: String,
    @SerializedName("Released") val releaseDate: String,
    @SerializedName("Genre") val genres: String,
    @SerializedName("imdbRating") val imdbRating: String,
    @SerializedName("imdbVotes") val imdbVotes: String,
) {

    val genresAsList: List<String>
        get() = genres.split(",").map { it.trim() }

}