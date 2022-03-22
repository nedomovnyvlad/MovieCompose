package com.vnedomovnyi.moviecompose.ui.entity

import org.threeten.bp.LocalDateTime

data class Movie(
    val title: String,
    val overview: String,
    val releaseDate: LocalDateTime,
    val rating: Float,
    val rateCount: Int,
    val popularity: Float,
    val smallImage: String,
    val bigImage: String,
)