package com.example.explorer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.explorer.feature.detail.navigation.detailScreen
import com.example.explorer.feature.detail.navigation.navigateToDetail
import com.example.explorer.feature.search.navigation.searchRoute
import com.example.explorer.feature.search.navigation.searchScreen


@Composable
fun ExplorerNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = searchRoute,
        modifier = modifier
    ) {
        searchScreen(
            onItemClick = navController::navigateToDetail
        )
        detailScreen()
    }
}
