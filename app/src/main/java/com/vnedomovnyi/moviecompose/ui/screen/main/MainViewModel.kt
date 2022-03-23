package com.vnedomovnyi.moviecompose.ui.screen.main

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.vnedomovnyi.moviecompose.entity.Movie

class MainViewModel : ViewModel() {

    val movies = mutableStateListOf<Movie>()

    init {
        movies.addAll(MOCK_MOVIES)
    }

    companion object {
        private val MOCK_MOVIE = Movie(
            id = "",
            title = "Spiderman No Way Home",
            year = 1997,
            posterUrl = "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg"
        )

        private val MOCK_MOVIES = Array(10) { MOCK_MOVIE }.toList()
    }
}