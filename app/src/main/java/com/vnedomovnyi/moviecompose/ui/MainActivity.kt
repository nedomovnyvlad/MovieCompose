package com.vnedomovnyi.moviecompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vnedomovnyi.moviecompose.ui.navigation.MovieComposeNavHost
import com.vnedomovnyi.moviecompose.ui.theme.MovieComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }

    @Composable
    private fun Content() {
        MovieComposeTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                MovieComposeNavHost()
            }
        }
    }
}