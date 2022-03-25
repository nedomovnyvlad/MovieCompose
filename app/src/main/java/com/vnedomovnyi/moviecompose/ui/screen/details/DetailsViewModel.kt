package com.vnedomovnyi.moviecompose.ui.screen.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vnedomovnyi.moviecompose.entity.MovieDetails
import com.vnedomovnyi.moviecompose.network.MovieService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val movieService: MovieService,
) : ViewModel() {

    private lateinit var movieId: String

    val movieDetails = mutableStateOf<MovieDetails?>(null)

    fun initialize(movieId: String) {
        this.movieId = movieId

        viewModelScope.launch {
            movieDetails.value = movieService.getMovieDetails(movieId)
        }
    }

}