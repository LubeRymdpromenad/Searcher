package com.example.explorer

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.example.explorer.navigation.ExplorerNavHost


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExplorerApp() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.displaySmall
                    )
                }
            )
        }
    ) { innerPadding ->
        ExplorerNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}
