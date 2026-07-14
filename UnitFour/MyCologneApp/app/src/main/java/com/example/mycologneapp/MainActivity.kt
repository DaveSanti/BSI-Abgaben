package com.example.mycologneapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycologneapp.ui.CologneApp
import com.example.mycologneapp.ui.theme.MyCologneAppTheme
import com.example.mycologneapp.ui.utils.CologneContentType

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCologneAppTheme {
                Surface {
                    val windowSize = calculateWindowSizeClass(this)
                    CologneApp(
                        contentType = contentTypeFor(windowSize.widthSizeClass)
                    )
                }
            }
        }
    }
}

private fun contentTypeFor(windowWidthSizeClass: WindowWidthSizeClass): CologneContentType {
    return when (windowWidthSizeClass) {
        WindowWidthSizeClass.Expanded -> CologneContentType.LIST_AND_DETAIL
        else -> CologneContentType.LIST_ONLY
    }
}

@Preview(showBackground = true, widthDp = 390)
@Composable
fun CologneAppCompactPreview() {
    MyCologneAppTheme {
        Surface {
            CologneApp(contentType = CologneContentType.LIST_ONLY)
        }
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun CologneAppExpandedPreview() {
    MyCologneAppTheme {
        Surface {
            CologneApp(contentType = CologneContentType.LIST_AND_DETAIL)
        }
    }
}
