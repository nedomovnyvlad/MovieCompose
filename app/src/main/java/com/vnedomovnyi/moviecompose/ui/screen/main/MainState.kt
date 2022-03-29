package com.vnedomovnyi.moviecompose.ui.screen.main

import com.vnedomovnyi.moviecompose.entity.Movie
import com.vnedomovnyi.moviecompose.ui.mvi.BaseState

data class MainState(
    val isLoading: Boolean,
    val movies: List<Movie>,
    val isSearching: Boolean,
) : BaseState {
    companion object {
        fun initial(): MainState = MainState(
            isLoading = false,
            movies = emptyList(),
            isSearching = false,
        )
    }
}