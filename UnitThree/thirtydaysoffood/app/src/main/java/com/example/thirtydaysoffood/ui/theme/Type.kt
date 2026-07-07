package com.example.thirtydaysoffood.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.thirtydaysoffood.R

private val Poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_extrabold, FontWeight.ExtraBold)
)

private val baseline = Typography()

val AppTypography = Typography(
    displaySmall = baseline.displaySmall.copy(
        fontFamily = Poppins,
        fontWeight = FontWeight.ExtraBold
    ),
    headlineSmall = baseline.headlineSmall.copy(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold
    ),
    titleLarge = baseline.titleLarge.copy(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold
    ),
    titleMedium = baseline.titleMedium.copy(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold
    ),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = Poppins),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = Poppins),
    labelLarge = baseline.labelLarge.copy(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold
    ),
    labelMedium = baseline.labelMedium.copy(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium
    )
)
