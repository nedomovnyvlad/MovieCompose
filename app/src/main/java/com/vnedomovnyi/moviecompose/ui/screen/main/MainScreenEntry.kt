package com.vnedomovnyi.moviecompose.ui.screen.main

import com.vnedomovnyi.moviecompose.ui.navigation.ScreenEntry

object MainScreenEntry : ScreenEntry<MainScreenEntryBuilder>() {
    override val routeScheme = "Main"
    override fun builder() = MainScreenEntryBuilder()
}