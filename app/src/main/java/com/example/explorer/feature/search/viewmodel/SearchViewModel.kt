package com.example.explorer.feature.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.explorer.core.data.GetSearchUseCase
import com.example.explorer.core.data.model.SearchItemsData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getSearchUseCase: GetSearchUseCase
) : ViewModel() {

    private val _searchState: MutableStateFlow<PagingData<SearchItemsData.SearchItemData>> = MutableStateFlow(value = PagingData.empty())
    val searchState: MutableStateFlow<PagingData<SearchItemsData.SearchItemData>> get() = _searchState

    private suspend fun getSearch(query: String) {
        getSearchUseCase.execute(query)
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
            .collect {
                _searchState.value = it
            }
    }

    fun makeSearch(query: String) {
        viewModelScope.launch {
            getSearch(query)
        }
    }
}
