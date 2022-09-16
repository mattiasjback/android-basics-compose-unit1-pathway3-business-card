package com.example.businesscard

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

private val androidColor = Color(0xFF3ddc84)

@Composable
fun LogoAndTitle() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        val image = painterResource(id = R.drawable.android_logo)
        Image(
            painter = image,
            contentDescription = "Android Logo",
            modifier = Modifier
                .width(60.dp)
                .height(60.dp),
            contentScale = ContentScale.FillHeight
        )
        Text(
            text = "Mattias Bäck",
            color = MaterialTheme.colors.onBackground,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(8.dp))
        Text(
            text = "Android Developer",
            color = androidColor,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ContactInfo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp)
            .padding(bottom = 16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        ContactInfoEntry(
            icon = R.drawable.ic_baseline_phone_24,
            text = "+46 (73) 123 45 56"
        )
        ContactInfoEntry(
            icon = R.drawable.ic_baseline_share_24,
            text = "@mattiasback"
        )
        ContactInfoEntry(
            icon = R.drawable.ic_baseline_email_24,
            text = "mat.bac@contouch.com"
        )
    }
}

@Composable
fun ContactInfoEntry(icon: Int, text: String) {
    Row(
        modifier = Modifier.padding(2.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(40.dp))
        val icon = painterResource(id = icon)
        Icon(icon, null, tint = androidColor)
        Spacer(modifier = Modifier.width(100.dp))
        Text(
            text = text,
            color = MaterialTheme.colors.onBackground)
    }
}

@Composable
fun BusinessCard() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(modifier = Modifier
            .wrapContentSize()
            .align(alignment = Alignment.Center)
        ) {
            LogoAndTitle()
        }

        Box(modifier = Modifier
            .wrapContentSize()
            .align(alignment = Alignment.BottomCenter)
        ) {
            ContactInfo()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            BusinessCard()
        }
    }
}