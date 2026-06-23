package com.example.artspace

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

data class Artwork(
    @param:DrawableRes val imageRes: Int,
    @param:StringRes val titleRes: Int,
    val year: Int
)

private val artworks = listOf(
    Artwork(R.drawable.image01, R.string.artwork_title_01, 1994),
    Artwork(R.drawable.image02, R.string.artwork_title_02, 2008),
    Artwork(R.drawable.image03, R.string.artwork_title_03, 2017),
    Artwork(R.drawable.image04, R.string.artwork_title_04, 1999),
    Artwork(R.drawable.image05, R.string.artwork_title_05, 2026),
    Artwork(R.drawable.image06, R.string.artwork_title_06, 2012),
    Artwork(R.drawable.image07, R.string.artwork_title_07, 1991),
    Artwork(R.drawable.image08, R.string.artwork_title_08, 2020),
    Artwork(R.drawable.image09, R.string.artwork_title_09, 2003),
    Artwork(R.drawable.image10, R.string.artwork_title_10, 2015)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF8F5F0)
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var currentArtworkIndex by remember { mutableIntStateOf(0) }
    val currentArtwork = artworks[currentArtworkIndex]

    Column(
        modifier = modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        ArtworkWall(
            artwork = currentArtwork,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        ArtworkDescriptor(
            artwork = currentArtwork,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp)
        )
        DisplayController(
            onPreviousClick = {
                currentArtworkIndex = if (currentArtworkIndex == 0) {
                    artworks.lastIndex
                } else {
                    currentArtworkIndex - 1
                }
            },
            onNextClick = {
                currentArtworkIndex = if (currentArtworkIndex == artworks.lastIndex) {
                    0
                } else {
                    currentArtworkIndex + 1
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ArtworkWall(artwork: Artwork, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shadowElevation = 8.dp,
        color = Color.White
    ) {
        Image(
            painter = painterResource(artwork.imageRes),
            contentDescription = stringResource(artwork.titleRes),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
                .aspectRatio(1f)
                .border(1.dp, Color(0xFFE0DED8))
        )
    }
}

@Composable
fun ArtworkDescriptor(artwork: Artwork, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color(0xFFECE7DF))
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(artwork.titleRes),
            fontSize = 24.sp,
            lineHeight = 30.sp,
            color = Color(0xFF26231F)
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = stringResource(R.string.artwork_year, artwork.year),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF38342F)
        )
    }
}

@Composable
fun DisplayController(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = stringResource(R.string.previous),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.width(24.dp))
        Button(
            onClick = onNextClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = stringResource(R.string.next),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}
