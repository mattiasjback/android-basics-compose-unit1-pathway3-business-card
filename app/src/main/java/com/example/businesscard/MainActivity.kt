package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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



private val nameSize = 32.sp
private val titleSize = 18.sp


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
        Logo()
        Text(
            text = "Mattias Bäck",
            color = MaterialTheme.colors.onBackground,
            fontSize = nameSize,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Android Developer",
            color = MaterialTheme.colors.secondary,
            fontSize = titleSize,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Logo() {
    //TODO logo
}

@Composable
fun ContactInfo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        ContactInfoEntry()
        ContactInfoEntry()
        ContactInfoEntry()
    }
}

@Composable
fun ContactInfoEntry() {
    Row(
        Modifier.padding(2.dp)
    ) {
        //TODO Icon(painter = , contentDescription = )
        Text(
            text = "phone number",
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