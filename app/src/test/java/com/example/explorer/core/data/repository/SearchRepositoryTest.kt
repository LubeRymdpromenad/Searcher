package com.example.explorer.core.data.repository

import com.example.explorer.core.network.model.FlickrResponse
import com.example.explorer.core.network.model.Photo
import com.example.explorer.core.network.model.Photos
import io.mockk.MockKAnnotations.init
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class SearchRepositoryTest {
    @MockK
    lateinit var photo: Photo

    @Before
    fun setup() {
        init(this, relaxed = true)
    }

    @Test
    fun getPlants() = runTest {
        // Given
        val testTitle = "test_title"
        every { photo.title } returns testTitle

        val repository = SearchRepository(
            FakeSearchApi(
                response = FlickrResponse(
                    photos = Photos(
                        page = 0,
                        photo = listOf(photo)
                    )
                )
            )
        )

        // When
        val response = repository.searchPhotos("", 0, 0)

        // Then
        assert(response.isNotEmpty())
        assert(response.first().title == testTitle)
    }
}
