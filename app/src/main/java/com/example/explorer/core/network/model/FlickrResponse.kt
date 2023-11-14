package com.example.explorer.core.network.model

import kotlinx.serialization.Serializable


@Serializable
data class FlickrResponse(
    val photos: Photos
)

@Serializable
data class Photos(
    val page: Int,
    val photo: List<Photo>
)

@Serializable
data class Photo(
    val id: String,
    val title: String,
    val secret: String,
    val server: String,
)
