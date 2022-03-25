package com.vnedomovnyi.moviecompose.ui.mvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<
        State : BaseState,
        Event : BaseUiEvent,
        Reducer : BaseReducer<State, Event>
        >
    : ViewModel() {

    abstract val reducer: Reducer

    val state: StateFlow<State>
        get() = reducer.state
}