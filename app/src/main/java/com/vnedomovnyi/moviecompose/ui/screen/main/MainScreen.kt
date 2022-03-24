package com.vnedomovnyi.moviecompose.ui.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.vnedomovnyi.moviecompose.R
import com.vnedomovnyi.moviecompose.entity.Movie

@Composable
fun MainScreen(viewModel: MainViewModel, onMovieClick: (String) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 28.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Column {
                Text(
                    stringResource(R.string.app_name),
                    style = MaterialTheme.typography.h1
                )
            }
        }
        items(viewModel.movies) { movie ->
            MovieItem(
                movie = movie,
                onClick = { id -> onMovieClick(id) }
            )
        }
    }
}

@Composable
private fun MovieItem(movie: Movie, onClick: (String) -> Unit) {
    Row(modifier = Modifier.clickable { onClick(movie.id) }) {
        Image(
            painter = rememberAsyncImagePainter(model = movie.posterUrl),
            contentDescription = null,
            modifier = Modifier
                .size(width = 95.dp, height = 120.dp)
                .clip(MaterialTheme.shapes.large)
        )

        Spacer(modifier = Modifier.width(22.dp))

        Column {
            Text(stringResource(R.string.title), style = MaterialTheme.typography.h3)
            Text(movie.title, style = MaterialTheme.typography.body1)

            Spacer(Modifier.height(5.dp))

            Text(stringResource(R.string.release_year), style = MaterialTheme.typography.h3)
            Text(
                movie.year,
                style = MaterialTheme.typography.body1
            )
        }
    }
}