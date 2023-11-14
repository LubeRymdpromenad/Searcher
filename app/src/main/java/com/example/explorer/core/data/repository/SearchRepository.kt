package com.example.explorer.core.data.repository

import com.example.explorer.core.data.model.SearchItemsData
import com.example.explorer.core.data.model.asModel
import com.example.explorer.core.network.api.SearchApi
import javax.inject.Singleton


@Singleton
class SearchRepository(
    private val searchApi: SearchApi
) {
    suspend fun searchPhotos(query: String, page: Int, perPage: Int): List<SearchItemsData.SearchItemData> =
            searchApi.searchPhotos(query, page, perPage).photos.photo.map { it.asModel() }
}
