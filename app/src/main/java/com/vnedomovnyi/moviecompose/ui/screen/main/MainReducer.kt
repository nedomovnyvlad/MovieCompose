package com.vnedomovnyi.moviecompose.ui.screen.main

import com.vnedomovnyi.moviecompose.ui.mvi.BaseReducer

class MainReducer : BaseReducer<MainState, MainEvent>(MainState.initial()) {

    override fun reduce(oldState: MainState, event: MainEvent) {
        when (event) {
            is MainEvent.MoviesLoaded -> {
                setState(oldState.copy(isLoading = false, movies = event.movies))
            }
            is MainEvent.LoadingStarted -> setState(
                oldState.copy(
                    isLoading = true,
                    movies = emptyList()
                )
            )
            is MainEvent.SearchQueryChanged -> {
                val isSearching = event.query.isNotEmpty()

                setState(
                    oldState.copy(
                        isLoading = if (isSearching) oldState.isLoading else false,
                        movies = if (isSearching) oldState.movies else emptyList(),
                        isSearching = isSearching,
                    )
                )
            }
        }
    }
}