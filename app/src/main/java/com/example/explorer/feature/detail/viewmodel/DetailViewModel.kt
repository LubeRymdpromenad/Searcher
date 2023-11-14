package com.example.explorer.feature.detail.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.explorer.core.data.model.SearchItemsData
import com.example.explorer.feature.detail.navigation.NAV_ARG_DATA
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


data class DetailViewState(
    val itemData: SearchItemsData.SearchItemData = SearchItemsData.SearchItemData()
)

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val viewState = mutableStateOf(DetailViewState())

    init {
        savedStateHandle.get<SearchItemsData.SearchItemData>(NAV_ARG_DATA)?.let {
            viewState.value = viewState.value.copy(itemData = it)
        }
    }
}
