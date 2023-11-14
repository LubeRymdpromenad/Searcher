package com.example.explorer.core.data.repository

import com.example.explorer.core.network.api.SearchApi
import com.example.explorer.core.network.model.FlickrResponse

class FakeSearchApi(private val response: FlickrResponse) : SearchApi {
    override suspend fun searchPhotos(
        text: String,
        page: Int,
        perPage: Int,
        apiKey: String
    ): FlickrResponse = response
}
