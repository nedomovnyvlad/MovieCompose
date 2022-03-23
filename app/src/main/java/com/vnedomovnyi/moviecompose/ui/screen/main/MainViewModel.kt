package com.vnedomovnyi.moviecompose.ui.screen.main

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vnedomovnyi.moviecompose.entity.Movie
import com.vnedomovnyi.moviecompose.network.MovieService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    movieService: MovieService
) : ViewModel() {

    val movies = mutableStateListOf<Movie>()

    init {
        viewModelScope.launch {
            val response = movieService.getMovies("Test")
            movies.addAll(response.movies)
        }
    }
}