package com.vnedomovnyi.moviecompose.ui.screen.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberAsyncImagePainter
import com.vnedomovnyi.moviecompose.R
import com.vnedomovnyi.moviecompose.entity.MovieDetails
import com.vnedomovnyi.moviecompose.ui.theme.BrightGray
import com.vnedomovnyi.moviecompose.ui.theme.Gallery

@Composable
fun DetailsScreen(viewModel: DetailsViewModel) {
    val details = viewModel.movieDetails.value

    if (details == null) {
        ProgressBar()
    } else {
        Content(details)
    }
}

@Composable
private fun ProgressBar() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun Content(details: MovieDetails) {
    ConstraintLayout(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(bottom = 24.dp)
    ) {
        val (bigImage, smallImage, title, genres, plot, releaseDate, averageRating, rateCount)
                = createRefs()

        val painter = rememberAsyncImagePainter(model = details.posterUrl)

        val horizontalOffset = 28.dp
        val startGuideline = createGuidelineFromStart(offset = horizontalOffset)
        val endGuideline = createGuidelineFromEnd(offset = horizontalOffset)

        Image(
            painter = painter,
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(210.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                .constrainAs(bigImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Image(
            painter = painter,
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(95.dp)
                .height(120.dp)
                .clip(MaterialTheme.shapes.large)
                .constrainAs(smallImage) {
                    start.linkTo(startGuideline)
                    top.linkTo(bigImage.bottom)
                    bottom.linkTo(bigImage.bottom)
                }
        )

        Text(
            text = details.title,
            style = MaterialTheme.typography.h2,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.constrainAs(title) {
                start.linkTo(smallImage.end, margin = 12.dp)
                end.linkTo(endGuideline)
                top.linkTo(bigImage.bottom)
                bottom.linkTo(smallImage.bottom)
                width = Dimension.fillToConstraints
            }
        )

        LazyRow(
            modifier = Modifier.constrainAs(genres) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(smallImage.bottom, margin = 20.dp)
                width = Dimension.fillToConstraints
            },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = horizontalOffset)
        ) {
            items(details.genresAsList) { genre ->
                Text(
                    text = genre,
                    style = MaterialTheme.typography.body1,
                    color = Gallery,
                    modifier = Modifier
                        .background(BrightGray, MaterialTheme.shapes.large)
                        .padding(horizontal = 20.dp, vertical = 4.dp)
                )
            }
        }

        TextWithTitle(
            modifier = Modifier.constrainAs(plot) {
                start.linkTo(startGuideline)
                end.linkTo(endGuideline)
                top.linkTo(genres.bottom, margin = 20.dp)
                width = Dimension.fillToConstraints
            },
            title = stringResource(R.string.plot),
            text = details.plot,
        )

        TextWithTitle(
            modifier = Modifier.constrainAs(releaseDate) {
                start.linkTo(startGuideline)
                end.linkTo(endGuideline)
                top.linkTo(plot.bottom, margin = 12.dp)
                width = Dimension.fillToConstraints
            },
            title = stringResource(R.string.release_date),
            text = details.releaseDate,
        )

        TextWithTitle(
            modifier = Modifier.constrainAs(averageRating) {
                start.linkTo(startGuideline)
                end.linkTo(rateCount.start)
                top.linkTo(releaseDate.bottom, margin = 12.dp)
                width = Dimension.fillToConstraints
            },
            title = stringResource(R.string.average_rating),
            text = details.imdbRating,
        )

        TextWithTitle(
            modifier = Modifier.constrainAs(rateCount) {
                start.linkTo(averageRating.end)
                end.linkTo(endGuideline)
                top.linkTo(averageRating.top)
                width = Dimension.fillToConstraints
            },
            title = stringResource(R.string.rate_count),
            text = details.imdbVotes,
        )
    }
}

@Composable
fun TextWithTitle(modifier: Modifier, title: String, text: String) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.h3,
        )
        Text(
            text = text,
            style = MaterialTheme.typography.body1,
        )
    }
}