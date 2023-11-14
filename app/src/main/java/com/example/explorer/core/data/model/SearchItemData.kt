package com.example.explorer.core.data.model

import android.os.Parcelable
import com.example.explorer.core.network.model.Photo
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


data class SearchItemsData(
    val searchItems: List<SearchItemData> = emptyList()
) {
    @Parcelize
    @Serializable
    data class SearchItemData(
        val title: String  = "",
        val smallImageUrl: String = "",
        val largeImageUrl: String = ""
    ) : Parcelable
}

internal fun Photo.asModel(): SearchItemsData.SearchItemData = SearchItemsData.SearchItemData(
    title = title,
    smallImageUrl = "https://live.staticflickr.com/${server}/${id}_${secret}_${SMALL_IMAGE}.jpg",
    largeImageUrl = "https://live.staticflickr.com/${server}/${id}_${secret}_${LARGE_IMAGE}.jpg"
)

private const val SMALL_IMAGE = "m"
private const val LARGE_IMAGE = "z"
