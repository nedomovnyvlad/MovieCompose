package com.vnedomovnyi.moviecompose.ui.screen.details

import com.vnedomovnyi.moviecompose.entity.MovieDetails
import com.vnedomovnyi.moviecompose.ui.mvi.BaseState

data class DetailsState(
    val isLoading: Boolean,
    val details: MovieDetails?,
) : BaseState {
    companion object {
        fun initial(): DetailsState = DetailsState(
            isLoading = true,
            details = null,
        )
    }
}