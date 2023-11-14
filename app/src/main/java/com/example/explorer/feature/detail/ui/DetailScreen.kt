package com.example.explorer.feature.detail.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.explorer.core.data.model.SearchItemsData
import com.example.explorer.feature.detail.viewmodel.DetailViewModel
import com.example.explorer.feature.detail.viewmodel.DetailViewState


@Composable
internal fun DetailRoute(
    viewModel: DetailViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState
    DetailScreen(
        viewState = viewState
    )
}

@Composable
internal fun DetailScreen(
    viewState: DetailViewState
) {
    Column {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .crossfade(true)
                .data(viewState.itemData.largeImageUrl)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            modifier = Modifier
                .height(300.dp)
                .background(Color.LightGray)
        )
        Text(
            text = viewState.itemData.title,
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Detail_preview() {
    DetailScreen(
        viewState = DetailViewState(SearchItemsData.SearchItemData(title = "Electric guitar"))
    )
}