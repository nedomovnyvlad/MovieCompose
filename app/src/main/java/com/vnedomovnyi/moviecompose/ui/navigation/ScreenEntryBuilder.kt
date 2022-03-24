package com.vnedomovnyi.moviecompose.ui.navigation

abstract class ScreenEntryBuilder<T : ScreenEntryBuilder<T>> {
    abstract fun build(block: T.() -> Unit): String
}