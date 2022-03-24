package com.vnedomovnyi.moviecompose.ui.screen.details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun DetailsScreen(movieId: String) {
    Text(movieId, modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
}