package com.vnedomovnyi.moviecompose.ui.screen.main

import com.vnedomovnyi.moviecompose.ui.mvi.BaseReducer

class MainReducer : BaseReducer<MainState, MainEvent>(MainState.initial()) {

    override fun reduce(oldState: MainState, event: MainEvent) {
        when (event) {
            is MainEvent.MoviesLoaded -> {
                setState(oldState.copy(movies = event.movies, isLoading = false))
            }
        }
    }
}