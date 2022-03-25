package com.vnedomovnyi.moviecompose.ui.screen.main

import com.vnedomovnyi.moviecompose.entity.Movie
import com.vnedomovnyi.moviecompose.ui.mvi.BaseUiEvent

sealed class MainEvent : BaseUiEvent {
    data class MoviesLoaded(val movies: List<Movie>) : MainEvent()
}