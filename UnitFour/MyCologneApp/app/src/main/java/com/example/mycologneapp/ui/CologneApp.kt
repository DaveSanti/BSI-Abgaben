package com.example.mycologneapp.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycologneapp.R
import com.example.mycologneapp.ui.utils.CologneContentType

enum class CologneScreen(@param:StringRes val title: Int) {
    Categories(title = R.string.categories_title),
    Places(title = R.string.all_places),
    Details(title = R.string.details)
}

@Composable
fun CologneApp(
    contentType: CologneContentType,
    modifier: Modifier = Modifier,
    viewModel: CologneViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uiState by viewModel.uiState.collectAsState()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = CologneScreen.valueOf(
        backStackEntry?.destination?.route ?: CologneScreen.Categories.name
    )
    val isExpanded = contentType == CologneContentType.LIST_AND_DETAIL

    Scaffold(
        topBar = {
            CologneAppBar(
                currentScreen = if (isExpanded) CologneScreen.Categories else currentScreen,
                canNavigateBack = !isExpanded && navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = CologneScreen.Categories.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = CologneScreen.Categories.name) {
                if (isExpanded) {
                    CologneExpandedScreen(
                        uiState = uiState,
                        onCategorySelected = viewModel::selectCategory,
                        onPlaceSelected = viewModel::selectPlace
                    )
                } else {
                    CategoryScreen(
                        categories = uiState.categories,
                        selectedCategoryId = uiState.selectedCategory.id,
                        onCategorySelected = { categoryId ->
                            viewModel.selectCategory(categoryId)
                            navController.navigate(CologneScreen.Places.name)
                        }
                    )
                }
            }
            composable(route = CologneScreen.Places.name) {
                if (isExpanded) {
                    CologneExpandedScreen(
                        uiState = uiState,
                        onCategorySelected = viewModel::selectCategory,
                        onPlaceSelected = viewModel::selectPlace
                    )
                } else {
                    PlacesScreen(
                        category = uiState.selectedCategory,
                        places = uiState.placesInSelectedCategory,
                        selectedPlaceId = uiState.selectedPlace.id,
                        onPlaceSelected = { placeId ->
                            viewModel.selectPlace(placeId)
                            navController.navigate(CologneScreen.Details.name)
                        }
                    )
                }
            }
            composable(route = CologneScreen.Details.name) {
                if (isExpanded) {
                    CologneExpandedScreen(
                        uiState = uiState,
                        onCategorySelected = viewModel::selectCategory,
                        onPlaceSelected = viewModel::selectPlace
                    )
                } else {
                    PlaceDetailScreen(place = uiState.selectedPlace)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CologneAppBar(
    currentScreen: CologneScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(currentScreen.title),
                style = MaterialTheme.typography.titleLarge
            )
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        },
        modifier = modifier
    )
}
