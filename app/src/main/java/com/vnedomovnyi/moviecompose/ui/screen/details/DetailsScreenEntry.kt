package com.vnedomovnyi.moviecompose.ui.screen.details

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.vnedomovnyi.moviecompose.ui.navigation.ScreenEntry

object DetailsScreenEntry : ScreenEntry<DetailsScreenEntryBuilder>() {
    const val NAME = "Details"
    private const val ARGUMENT_ID = "id"

    override val routeScheme = "$NAME/{$ARGUMENT_ID}"

    override val arguments = listOf(
        navArgument(ARGUMENT_ID) {
            type = NavType.StringType
        }
    )

    override fun builder() = DetailsScreenEntryBuilder()

    fun extractMovieId(entry: NavBackStackEntry): String =
        entry.arguments?.getString(ARGUMENT_ID) ?: ""
}