package com.example.explorer.feature.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.explorer.core.data.PER_PAGE
import com.example.explorer.core.data.SearchDataSource
import com.example.explorer.core.data.model.SearchItemsData
import com.example.explorer.core.data.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {
    private var searchDataSource: SearchDataSource = SearchDataSource(
        query = "",
        searchRepository = searchRepository
    )

    fun makeSearch(query: String) {
        searchDataSource.invalidate()
        searchDataSource = SearchDataSource(
            query = query,
            searchRepository = searchRepository
        )
    }

    fun getSearchData(): Flow<PagingData<SearchItemsData.SearchItemData>> =
        Pager(PagingConfig(PER_PAGE)) { searchDataSource }.flow
}
