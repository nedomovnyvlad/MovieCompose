package com.vnedomovnyi.moviecompose.ui.screen.main

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.vnedomovnyi.moviecompose.R
import com.vnedomovnyi.moviecompose.entity.Movie

@Composable
fun MainScreen(viewModel: MainViewModel, onMovieClick: (String) -> Unit) {
    val state by viewModel.state.collectAsState()

    Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 28.dp)) {
        Title()
        Spacer(modifier = Modifier.height(16.dp))
        SearchView(onTextChanged = { viewModel.onSearchTextChanged(it) })

        with(state) {
            when {
                movies.isNotEmpty() -> Content(movies = state.movies, onMovieClick = onMovieClick)
                isLoading -> LoadingView()
                movies.isEmpty() && isSearching -> MessageToUser(R.string.no_results)
                movies.isEmpty() && !isSearching -> MessageToUser(R.string.call_to_search)
            }
        }
    }
}

@Composable
private fun LoadingView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun MessageToUser(@StringRes id: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = stringResource(id = id),
            style = MaterialTheme.typography.body1.copy(fontSize = 16.sp),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.weight(3f))
    }
}

@Composable
private fun Content(
    movies: List<Movie>,
    onMovieClick: (String) -> Unit,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        item { Spacer(modifier = Modifier.height(12.dp)) }

        items(movies) { movie ->
            MovieItem(
                movie = movie,
                onClick = { id -> onMovieClick(id) }
            )
        }
    }
}

@Composable
private fun Title() {
    Text(
        stringResource(R.string.app_name),
        style = MaterialTheme.typography.h1
    )
}

@Composable
fun SearchView(onTextChanged: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(stringResource(R.string.find_movie), style = MaterialTheme.typography.h2)
        Spacer(modifier = Modifier.height(16.dp))
        SearchTextField(onTextChanged = onTextChanged)
    }
}

@Composable
fun SearchTextField(onTextChanged: (String) -> Unit) {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        textStyle = MaterialTheme.typography.body1.copy(fontSize = 14.sp),
        placeholder = { Text(stringResource(R.string.search_movie)) },
        shape = MaterialTheme.shapes.large,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Transparent,
            unfocusedIndicatorColor = Transparent,
        ),
        value = text,
        onValueChange = {
            text = it
            onTextChanged(it)
        },
    )
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