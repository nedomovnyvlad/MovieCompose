package com.vnedomovnyi.moviecompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vnedomovnyi.moviecompose.ui.screen.main.MainScreen
import com.vnedomovnyi.moviecompose.ui.screen.main.MainViewModel
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
        val navController = rememberNavController()

        MovieComposeTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                NavHost(
                    navController = navController,
                    startDestination = ScreenEntry.Main.name,
                ) {
                    composable(ScreenEntry.Main.name) {
                        MainScreen(viewModels<MainViewModel>().value)
                    }
                }
            }
        }
    }
}