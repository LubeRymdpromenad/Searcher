package com.example.explorer.feature.search.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.explorer.core.data.model.SearchItemsData
import com.example.explorer.feature.search.ui.SearchRoute


internal const val searchRoute = "search_route"

fun NavGraphBuilder.searchScreen(
    onItemClick: (itemData: SearchItemsData.SearchItemData) -> Unit
) {
    composable(
        route = searchRoute
    ) {
        SearchRoute(
            onItemClick = onItemClick
        )
    }
}
