package com.example.mycologneapp.model

import androidx.compose.ui.graphics.Color

data class PlaceCategory(
    val id: String,
    val name: String,
    val description: String,
    val color: Color
)

data class ColognePlace(
    val id: String,
    val categoryId: String,
    val name: String,
    val district: String,
    val shortDescription: String,
    val details: String,
    val bestFor: String,
    val latitude: Double,
    val longitude: Double
)
