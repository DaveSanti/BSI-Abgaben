package com.example.thirtydaysoffood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtydaysoffood.ui.theme.ThirtyDaysOfFoodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThirtyDaysOfFoodTheme {
                ThirtyDaysOfFoodApp()
            }
        }
    }
}

data class FoodTip(
    val day: Int,
    @param:DrawableRes val imageRes: Int
)

@Composable
fun ThirtyDaysOfFoodApp() {
    Scaffold(
        topBar = { FoodTopBar() },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp,
                bottom = 24.dp
            )
        ) {
            items(foodTips, key = { it.day }) { tip ->
                FoodTipCard(tip = tip)
            }
        }
    }
}

@Composable
fun FoodTopBar(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.primary,
        shadowElevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .statusBarsPadding()
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(7.dp)
            )
            Column {
                Text(
                    text = "30 Days of Food",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = "In dieser App werden 30 Gerichte gezeigt und vorgestellt.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.82f)
                )
            }
        }
    }
}

@Composable
fun FoodTipCard(tip: FoodTip, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            DayBadge(day = tip.day)
            Image(
                painter = painterResource(tip.imageRes),
                contentDescription = "Gericht ${tip.day}",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
                    .height(210.dp)
                    .clip(RoundedCornerShape(18.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun DayBadge(day: Int, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(14.dp),
        color = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.onSecondaryContainer
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = day.toString().padStart(2, '0'),
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.White
                )
            }
            Text(
                text = "Tag $day",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

private val foodTips = listOf(
    FoodTip(1, R.drawable.img01),
    FoodTip(2, R.drawable.img02),
    FoodTip(3, R.drawable.img03),
    FoodTip(4, R.drawable.img04),
    FoodTip(5, R.drawable.img05),
    FoodTip(6, R.drawable.img06),
    FoodTip(7, R.drawable.img07),
    FoodTip(8, R.drawable.img08),
    FoodTip(9, R.drawable.img09),
    FoodTip(10, R.drawable.img10),
    FoodTip(11, R.drawable.img11),
    FoodTip(12, R.drawable.img12),
    FoodTip(13, R.drawable.img13),
    FoodTip(14, R.drawable.img14),
    FoodTip(15, R.drawable.img15),
    FoodTip(16, R.drawable.img16),
    FoodTip(17, R.drawable.img17),
    FoodTip(18, R.drawable.img18),
    FoodTip(19, R.drawable.img19),
    FoodTip(20, R.drawable.img20),
    FoodTip(21, R.drawable.img21),
    FoodTip(22, R.drawable.img22),
    FoodTip(23, R.drawable.img23),
    FoodTip(24, R.drawable.img24),
    FoodTip(25, R.drawable.img25),
    FoodTip(26, R.drawable.img26),
    FoodTip(27, R.drawable.img27),
    FoodTip(28, R.drawable.img28),
    FoodTip(29, R.drawable.img29),
    FoodTip(30, R.drawable.img30)
)

@Preview(showBackground = true)
@Composable
fun ThirtyDaysOfFoodPreview() {
    ThirtyDaysOfFoodTheme {
        ThirtyDaysOfFoodApp()
    }
}
