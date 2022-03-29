package com.vnedomovnyi.moviecompose.ui.screen.main

import androidx.lifecycle.viewModelScope
import com.vnedomovnyi.moviecompose.network.MovieService
import com.vnedomovnyi.moviecompose.ui.mvi.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject

@Suppress("EXPERIMENTAL_IS_NOT_ENABLED")
@OptIn(FlowPreview::class)
@HiltViewModel
class MainViewModel @Inject constructor(
    private val movieService: MovieService
) : BaseViewModel<MainState, MainEvent, MainReducer>() {

    override val reducer = MainReducer()

    private val queryFlow: MutableStateFlow<String> = MutableStateFlow("")

    private var loadingJob: Job? = null

    init {
        viewModelScope.launch {
            queryFlow.debounce(DEBOUNCE_TIME).collectLatest { loadMovies(it) }
        }
    }

    fun onSearchTextChanged(text: String) {
        queryFlow.tryEmit(text)
    }

    private fun loadMovies(query: String) {
        loadingJob?.cancel()
        reducer.sendEvent(MainEvent.SearchQueryChanged(query))

        if (query.isEmpty()) return

        reducer.sendEvent(MainEvent.LoadingStarted)

        loadingJob = viewModelScope.launch {
            val response = movieService.getMovies(query)
            reducer.sendEvent(MainEvent.MoviesLoaded(response.movies ?: emptyList()))
        }
    }

    private companion object {
        const val DEBOUNCE_TIME = 300L
    }
}