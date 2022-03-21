package com.vnedomovnyi.moviecompose.ui.screen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun MainScreen() {
    Column {
        Text("Hello h1", style = MaterialTheme.typography.h1)
        Text("Hello h2", style = MaterialTheme.typography.h2)
        Text("Hello h3", style = MaterialTheme.typography.h3)
        Text("Hello body1", style = MaterialTheme.typography.body1)
        Text("Hello button", style = MaterialTheme.typography.button)
    }
}