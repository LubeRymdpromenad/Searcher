package com.example.explorer.feature.detail.ui

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.explorer.core.data.model.SearchItemsData
import com.example.explorer.feature.detail.viewmodel.DetailViewState
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun detail_show_title() {
        // Given
        val testTitle = "test_title"

        composeTestRule.setContent {
            DetailScreen(
                viewState = DetailViewState(SearchItemsData.SearchItemData(title = testTitle)),
            )
        }

        // When, Then
        composeTestRule
            .onNodeWithText(testTitle)
            .assertIsDisplayed()

    }
}