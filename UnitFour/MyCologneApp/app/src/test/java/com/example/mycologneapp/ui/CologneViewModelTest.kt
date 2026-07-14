package com.example.mycologneapp.ui

import com.example.mycologneapp.data.CologneDataSource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CologneViewModelTest {
    private val viewModel = CologneViewModel()

    @Test
    fun cologneViewModel_SelectCategory_PlacesAndSelectionUpdated() {
        viewModel.selectCategory("parks")

        val uiState = viewModel.uiState.value

        assertEquals("parks", uiState.selectedCategory.id)
        assertTrue(uiState.placesInSelectedCategory.all { it.categoryId == "parks" })
        assertEquals(uiState.placesInSelectedCategory.first(), uiState.selectedPlace)
    }

    @Test
    fun cologneViewModel_SelectPlace_SelectedPlaceUpdated() {
        val place = CologneDataSource.placeFor("rheinauhafen")

        viewModel.selectPlace(place.id)

        assertEquals(place, viewModel.uiState.value.selectedPlace)
    }
}
