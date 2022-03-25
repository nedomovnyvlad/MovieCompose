package com.vnedomovnyi.moviecompose.ui.screen.main

import androidx.lifecycle.viewModelScope
import com.vnedomovnyi.moviecompose.network.MovieService
import com.vnedomovnyi.moviecompose.ui.mvi.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    movieService: MovieService
) : BaseViewModel<MainState, MainEvent, MainReducer>() {

    override val reducer = MainReducer()

    init {
        viewModelScope.launch {
            val response = movieService.getMovies("Test")
            reducer.sendEvent(MainEvent.MoviesLoaded(response.movies))
        }
    }
}