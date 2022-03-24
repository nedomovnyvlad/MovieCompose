package com.vnedomovnyi.moviecompose.ui.screen.details

import com.vnedomovnyi.moviecompose.ui.navigation.ScreenEntryBuilder

data class DetailsScreenEntryBuilder(
    var movieId: String = ""
) : ScreenEntryBuilder<DetailsScreenEntryBuilder>() {

    override fun build(block: DetailsScreenEntryBuilder.() -> Unit): String {
        apply(block)
        return "${DetailsScreenEntry.NAME}/$movieId"
    }

}