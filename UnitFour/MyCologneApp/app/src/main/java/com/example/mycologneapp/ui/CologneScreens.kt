package com.example.mycologneapp.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycologneapp.R
import com.example.mycologneapp.data.CologneDataSource
import com.example.mycologneapp.model.ColognePlace
import com.example.mycologneapp.model.PlaceCategory
import com.example.mycologneapp.ui.theme.MyCologneAppTheme

private const val COLOGNE_NORTH = 50.985
private const val COLOGNE_SOUTH = 50.875
private const val COLOGNE_WEST = 6.850
private const val COLOGNE_EAST = 7.035

@Composable
fun CategoryScreen(
    categories: List<PlaceCategory>,
    selectedCategoryId: String,
    onCategorySelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            CologneMapCard(
                places = CologneDataSource.places,
                selectedPlace = null,
                modifier = Modifier.fillMaxWidth()
            )
        }
        items(categories, key = { it.id }) { category ->
            CategoryRow(
                category = category,
                selected = category.id == selectedCategoryId,
                onClick = { onCategorySelected(category.id) }
            )
        }
    }
}

@Composable
fun PlacesScreen(
    category: PlaceCategory,
    places: List<ColognePlace>,
    selectedPlaceId: String,
    onPlaceSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = category.name,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = category.description,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        items(places, key = { it.id }) { place ->
            PlaceRow(
                place = place,
                selected = place.id == selectedPlaceId,
                onClick = { onPlaceSelected(place.id) }
            )
        }
    }
}

@Composable
fun PlaceDetailScreen(
    place: ColognePlace,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            CologneMapCard(
                places = CologneDataSource.places,
                selectedPlace = place,
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            PlaceDetailCard(place = place)
        }
    }
}

@Composable
fun CologneExpandedScreen(
    uiState: CologneUiState,
    onCategorySelected: (String) -> Unit,
    onPlaceSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .width(260.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                SectionTitle(text = stringResource(R.string.categories_title))
            }
            items(uiState.categories, key = { it.id }) { category ->
                CategoryRow(
                    category = category,
                    selected = category.id == uiState.selectedCategory.id,
                    onClick = { onCategorySelected(category.id) }
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .width(320.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                SectionTitle(text = uiState.selectedCategory.name)
            }
            items(uiState.placesInSelectedCategory, key = { it.id }) { place ->
                PlaceRow(
                    place = place,
                    selected = place.id == uiState.selectedPlace.id,
                    onClick = { onPlaceSelected(place.id) }
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                CologneMapCard(
                    places = CologneDataSource.places,
                    selectedPlace = uiState.selectedPlace,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                PlaceDetailCard(place = uiState.selectedPlace)
            }
        }
    }
}

@Composable
private fun CategoryRow(
    category: PlaceCategory,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        onClick = onClick,
        colors = CardDefaults.elevatedCardColors(
            containerColor = if (selected) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                MaterialTheme.colorScheme.surface
            }
        ),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .background(category.color, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Map,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
                Text(
                    text = category.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = category.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
private fun PlaceRow(
    place: ColognePlace,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (selected) {
                MaterialTheme.colorScheme.secondaryContainer
            } else {
                MaterialTheme.colorScheme.surface
            }
        ),
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Place,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(34.dp)
            )
            Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
                Text(
                    text = place.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = place.shortDescription,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
private fun PlaceDetailCard(
    place: ColognePlace,
    modifier: Modifier = Modifier
) {
    ElevatedCard(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Text(
                text = place.name,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            InfoLine(label = stringResource(R.string.district), value = place.district)
            InfoLine(label = stringResource(R.string.best_for), value = place.bestFor)
            Text(
                text = place.details,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
private fun InfoLine(label: String, value: String) {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(text = value, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 4.dp)
    )
}

@Composable
private fun CologneMapCard(
    places: List<ColognePlace>,
    selectedPlace: ColognePlace?,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = stringResource(R.string.map_title),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2010f / 1592f)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outlineVariant,
                        shape = RoundedCornerShape(6.dp)
                    )
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFF5F1E7),
                                Color(0xFFE8EEE6)
                            )
                        ),
                        shape = RoundedCornerShape(6.dp)
                    )
            ) {
                Image(
                    painter = painterResource(R.drawable.koelnkarte),
                    contentDescription = stringResource(R.string.map_title),
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )
                CologneMapPinsOverlay(
                    places = places,
                    selectedPlace = selectedPlace,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Composable
private fun CologneMapPinsOverlay(
    places: List<ColognePlace>,
    selectedPlace: ColognePlace?,
    modifier: Modifier = Modifier
) {
    val primary = MaterialTheme.colorScheme.primary
    val secondary = MaterialTheme.colorScheme.tertiary
    Canvas(modifier = modifier.padding(10.dp)) {
        val width = size.width
        val height = size.height
        fun project(latitude: Double, longitude: Double): Offset {
            val x = ((longitude - COLOGNE_WEST) / (COLOGNE_EAST - COLOGNE_WEST)).toFloat()
            val y = ((COLOGNE_NORTH - latitude) / (COLOGNE_NORTH - COLOGNE_SOUTH)).toFloat()
            return Offset(
                x = x.coerceIn(0.03f, 0.97f) * width,
                y = y.coerceIn(0.03f, 0.97f) * height
            )
        }

        places.forEach { place ->
            val point = project(place.latitude, place.longitude)
            val selected = place.id == selectedPlace?.id
            drawCircle(
                color = Color.White,
                radius = if (selected) 13.dp.toPx() else 9.dp.toPx(),
                center = point
            )
            drawCircle(
                color = if (selected) primary else secondary,
                radius = if (selected) 9.dp.toPx() else 6.dp.toPx(),
                center = point
            )
            drawCircle(
                color = Color.White,
                radius = if (selected) 3.dp.toPx() else 2.dp.toPx(),
                center = point
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 390)
@Composable
private fun CategoryScreenPreview() {
    MyCologneAppTheme {
        Surface {
            CategoryScreen(
                categories = CologneDataSource.categories,
                selectedCategoryId = CologneDataSource.defaultCategory().id,
                onCategorySelected = {}
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
private fun ExpandedScreenPreview() {
    MyCologneAppTheme {
        Surface {
            CologneExpandedScreen(
                uiState = CologneUiState(),
                onCategorySelected = {},
                onPlaceSelected = {}
            )
        }
    }
}
