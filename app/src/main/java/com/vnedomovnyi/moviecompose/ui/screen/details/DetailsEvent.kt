package com.vnedomovnyi.moviecompose.ui.screen.details

import com.vnedomovnyi.moviecompose.entity.MovieDetails
import com.vnedomovnyi.moviecompose.ui.mvi.BaseUiEvent

sealed class DetailsEvent : BaseUiEvent {
    data class DetailsLoaded(val details: MovieDetails) : DetailsEvent()
}