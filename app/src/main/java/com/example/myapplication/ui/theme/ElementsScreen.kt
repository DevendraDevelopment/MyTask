package com.example.myapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@Preview
@Composable
fun ElementsScreen() {
    Column() {
        Text(text = "2D Layout/Adaptation",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp).fillMaxSize(1f))
    }
        Image(
            painter = painterResource(id = R.drawable.arrow_down),
            contentDescription = "",
            modifier = Modifier
                .size(35.dp)
                .padding(8.dp)
        )
    }