package com.vnedomovnyi.moviecompose.ui.screen.details

import com.vnedomovnyi.moviecompose.ui.mvi.BaseReducer

class DetailsReducer : BaseReducer<DetailsState, DetailsEvent>(DetailsState.initial()) {

    override fun reduce(oldState: DetailsState, event: DetailsEvent) {
        when (event) {
            is DetailsEvent.DetailsLoaded -> {
                setState(oldState.copy(details = event.details, isLoading = false))
            }
        }
    }
}