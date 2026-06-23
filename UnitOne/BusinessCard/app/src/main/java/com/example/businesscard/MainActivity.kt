package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

private val BackgroundGreen = Color(0xFFD2E8D4)
private val AndroidGreen = Color(0xFF3DDC84)
private val TextGreen = Color(0xFF126A3A)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BackgroundGreen
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BackgroundGreen)
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(1f))
        ProfileSection(
            name = stringResource(R.string.full_name),
            title = stringResource(R.string.job_title)
        )
        Spacer(modifier = Modifier.weight(1f))
        ContactSection(
            phone = stringResource(R.string.phone_number),
            social = stringResource(R.string.social_handle),
            email = stringResource(R.string.email_address)
        )
    }
}

@Composable
fun ProfileSection(name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = stringResource(R.string.android_logo_description),
            modifier = Modifier
                .size(104.dp)
                .background(Color(0xFF073042))
                .padding(16.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = name,
            fontSize = 40.sp,
            lineHeight = 48.sp,
            color = Color(0xFF1F1F1F),
            fontWeight = FontWeight.Light
        )
        Text(
            text = title,
            fontSize = 16.sp,
            color = TextGreen,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContactSection(phone: String, social: String, email: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        ContactRow(
            icon = R.drawable.ic_phone,
            iconDescription = stringResource(R.string.phone_icon_description),
            text = phone
        )
        ContactRow(
            icon = R.drawable.ic_share,
            iconDescription = stringResource(R.string.social_icon_description),
            text = social
        )
        ContactRow(
            icon = R.drawable.ic_email,
            iconDescription = stringResource(R.string.email_icon_description),
            text = email
        )
    }
}

@Composable
fun ContactRow(icon: Int, iconDescription: String, text: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.width(240.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = iconDescription,
            tint = AndroidGreen,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(24.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFF1F1F1F)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}
