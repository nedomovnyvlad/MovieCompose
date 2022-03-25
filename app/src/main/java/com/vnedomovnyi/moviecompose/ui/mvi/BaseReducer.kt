package com.vnedomovnyi.moviecompose.ui.mvi

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseReducer<State : BaseState, Event : BaseUiEvent>(initialState: State) {

    private val _state = MutableStateFlow(initialState)

    val state: StateFlow<State> = _state

    fun sendEvent(event: Event) {
        reduce(_state.value, event)
    }

    fun setState(state: State) {
        _state.tryEmit(state)
    }

    abstract fun reduce(oldState: State, event: Event)

}