package com.vnedomovnyi.moviecompose.ui.screen.details

import androidx.lifecycle.viewModelScope
import com.vnedomovnyi.moviecompose.network.MovieService
import com.vnedomovnyi.moviecompose.ui.mvi.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val movieService: MovieService,
) : BaseViewModel<DetailsState, DetailsEvent, DetailsReducer>() {

    override val reducer = DetailsReducer()

    private lateinit var movieId: String


    fun initialize(movieId: String) {
        this.movieId = movieId

        viewModelScope.launch {
            val details = movieService.getMovieDetails(movieId)
            reducer.sendEvent(DetailsEvent.DetailsLoaded(details))
        }
    }

}