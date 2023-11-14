package com.example.explorer.core.network.api

import com.example.explorer.BuildConfig
import com.example.explorer.core.network.model.FlickrResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface SearchApi {
    @GET("?method=flickr.photos.search&format=json&nojsoncallback=1&media=photos")
    suspend fun searchPhotos(
        @Query("tags") text: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("api_key") apiKey: String = BuildConfig.FLICKR_API_KEY
    ): FlickrResponse
}
