package com.example.explorer.feature.detail.viewmodel

import androidx.compose.runtime.getValue
import androidx.lifecycle.SavedStateHandle
import com.example.explorer.core.data.model.SearchItemsData
import com.example.explorer.feature.detail.navigation.NAV_ARG_DATA
import io.mockk.MockKAnnotations.init
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class DetailViewModelTest {

    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        init(this)
    }

    @Test
    fun getViewState() = runTest {
        // Given
        val data = SearchItemsData.SearchItemData(title = "test_title")

        val savedStateHandle = SavedStateHandle(mapOf(NAV_ARG_DATA to data))

        // When
        val viewState by DetailViewModel(
            savedStateHandle = savedStateHandle
        ).viewState

        // Then
        assert(viewState.itemData == data)
    }
}