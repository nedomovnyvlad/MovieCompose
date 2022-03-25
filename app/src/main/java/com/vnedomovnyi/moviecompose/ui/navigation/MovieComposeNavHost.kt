package com.vnedomovnyi.moviecompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vnedomovnyi.moviecompose.ui.screen.details.DetailsScreen
import com.vnedomovnyi.moviecompose.ui.screen.details.DetailsScreenEntry
import com.vnedomovnyi.moviecompose.ui.screen.details.DetailsViewModel
import com.vnedomovnyi.moviecompose.ui.screen.main.MainScreen
import com.vnedomovnyi.moviecompose.ui.screen.main.MainScreenEntry

@Composable
fun MovieComposeNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainScreenEntry.builder().build { },
    ) {
        composable(MainScreenEntry.routeScheme) {
            MainScreen(
                viewModel = hiltViewModel(),
                onMovieClick = { movieId ->
                    navController.navigate(
                        DetailsScreenEntry.builder().build { this.movieId = movieId }
                    )
                }
            )
        }
        composable(
            route = DetailsScreenEntry.routeScheme, arguments = DetailsScreenEntry.arguments
        ) { entry ->
            val id = DetailsScreenEntry.extractMovieId(entry)
            DetailsScreen(hiltViewModel<DetailsViewModel>().apply { initialize(movieId = id) })
        }
    }
}