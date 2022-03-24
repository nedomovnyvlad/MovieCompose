package com.vnedomovnyi.moviecompose.ui.navigation

import androidx.navigation.NamedNavArgument

abstract class ScreenEntry<Builder : ScreenEntryBuilder<Builder>> {
    abstract val routeScheme: String
    open val arguments: List<NamedNavArgument> = emptyList()

    abstract fun builder(): Builder
}


