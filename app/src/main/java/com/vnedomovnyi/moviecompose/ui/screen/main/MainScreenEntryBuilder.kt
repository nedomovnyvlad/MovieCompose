package com.vnedomovnyi.moviecompose.ui.screen.main

import com.vnedomovnyi.moviecompose.ui.navigation.ScreenEntryBuilder

class MainScreenEntryBuilder : ScreenEntryBuilder<MainScreenEntryBuilder>() {
    override fun build(block: MainScreenEntryBuilder.() -> Unit) = MainScreenEntry.routeScheme
}