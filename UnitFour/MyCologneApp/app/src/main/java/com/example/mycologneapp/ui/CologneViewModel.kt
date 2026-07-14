package com.example.mycologneapp.ui

import androidx.lifecycle.ViewModel
import com.example.mycologneapp.data.CologneDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CologneViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CologneUiState())
    val uiState: StateFlow<CologneUiState> = _uiState.asStateFlow()

    fun selectCategory(categoryId: String) {
        val category = CologneDataSource.categoryFor(categoryId)
        val places = CologneDataSource.placesFor(categoryId)
        _uiState.update {
            it.copy(
                selectedCategory = category,
                placesInSelectedCategory = places,
                selectedPlace = places.firstOrNull() ?: CologneDataSource.defaultPlace()
            )
        }
    }

    fun selectPlace(placeId: String) {
        _uiState.update { it.copy(selectedPlace = CologneDataSource.placeFor(placeId)) }
    }
}
