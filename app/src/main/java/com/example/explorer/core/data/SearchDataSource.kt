package com.example.explorer.core.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.explorer.core.data.model.SearchItemsData
import com.example.explorer.core.data.repository.SearchRepository

const val PER_PAGE = 20

class SearchDataSource(
    private val query: String,
    private val searchRepository: SearchRepository,
) : PagingSource<Int, SearchItemsData.SearchItemData>() {

    override fun getRefreshKey(state: PagingState<Int, SearchItemsData.SearchItemData>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, SearchItemsData.SearchItemData> {
        return try {
            val nextPage = params.key ?: 1
            val data = searchRepository.searchPhotos(query, nextPage, PER_PAGE)

            LoadResult.Page(
                data = data,
                prevKey = if (nextPage == 1) null else nextPage.minus(1),
                nextKey = if (data.isEmpty()) null else nextPage.plus(1)
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}
