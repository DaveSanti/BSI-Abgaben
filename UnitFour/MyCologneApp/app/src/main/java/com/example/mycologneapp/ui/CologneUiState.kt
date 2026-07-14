package com.example.mycologneapp.ui

import com.example.mycologneapp.data.CologneDataSource
import com.example.mycologneapp.model.ColognePlace
import com.example.mycologneapp.model.PlaceCategory

data class CologneUiState(
    val categories: List<PlaceCategory> = CologneDataSource.categories,
    val selectedCategory: PlaceCategory = CologneDataSource.defaultCategory(),
    val placesInSelectedCategory: List<ColognePlace> = CologneDataSource.placesFor(selectedCategory.id),
    val selectedPlace: ColognePlace = CologneDataSource.defaultPlace()
)
