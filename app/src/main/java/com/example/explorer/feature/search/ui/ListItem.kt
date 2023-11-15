package com.example.explorer.feature.search.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.explorer.core.data.model.SearchItemsData.SearchItemData
import com.example.explorer.ui.theme.ExplorerTheme
import com.example.explorer.ui.theme.Typography


@Composable
internal fun ListItem(
    searchItemData: SearchItemData,
    onItemClick: (searchItemData: SearchItemData) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(
                onClick = {
                    onItemClick(searchItemData)
                },
            )
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .crossfade(true)
                .data(searchItemData.smallImageUrl)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            modifier = Modifier
                .size(120.dp, 90.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.LightGray)
        )

        Column(
            modifier = Modifier
                .height(90.dp)
                .padding(horizontal = 16.dp, vertical = 4.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = searchItemData.title,
                style = Typography.bodyLarge,
                maxLines = 4
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview_SearchListItem() {
    ExplorerTheme {
        ListItem(listItemSample.first()) {}
    }
}
