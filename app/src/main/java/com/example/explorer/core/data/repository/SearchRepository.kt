package com.example.explorer.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.explorer.core.data.PER_PAGE
import com.example.explorer.core.data.SearchDataSource
import com.example.explorer.core.data.model.SearchItemsData
import com.example.explorer.core.network.api.SearchApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton


@Singleton
class SearchRepository(
    private val searchApi: SearchApi,
) {
    suspend fun getSearchItems(query: String): Flow<PagingData<SearchItemsData.SearchItemData>> {
        return Pager(
            config = PagingConfig(pageSize = PER_PAGE, prefetchDistance = 2),
            pagingSourceFactory = {
                SearchDataSource(query, searchApi)
            }
        ).flow
    }
}
