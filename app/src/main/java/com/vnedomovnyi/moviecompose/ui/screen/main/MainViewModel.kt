package com.vnedomovnyi.moviecompose.ui.screen.main

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.vnedomovnyi.moviecompose.ui.entity.Movie
import org.threeten.bp.LocalDateTime

class MainViewModel : ViewModel() {

    val movies = mutableStateListOf<Movie>()

    init {
        movies.addAll(MOCK_MOVIES)
    }

    companion object {
        private val MOCK_MOVIE = Movie(
            title = "Spiderman No Way Home",
            overview = "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.",
            releaseDate = LocalDateTime.of(2019, 8, 25, 0, 0),
            rating = 9.9f,
            rateCount = 3000,
            popularity = 48.432423f,
            smallImage = "https://itc.ua/wp-content/uploads/2021/11/spider-man-no-way-home-1-770x963.jpg",
            bigImage = "https://www.brickfanatics.com/wp-content/uploads/Spider-Man-No-Way-Home-poster-featured-2.jpg",
        )

        private val MOCK_MOVIES = Array(10) { MOCK_MOVIE }.toList()
    }
}