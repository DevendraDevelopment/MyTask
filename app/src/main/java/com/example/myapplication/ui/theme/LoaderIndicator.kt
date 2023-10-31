package com.example.myapplication.ui.theme

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

val strokeWidth = 5.dp

@Composable
fun LoaderIndicator() {
    CircularProgressIndicator(
        modifier = Modifier
            .drawBehind {
                drawCircle(
                    Pink40,
                    radius = size.width / 2 - strokeWidth.toPx() / 2,
                    style = Stroke(strokeWidth.toPx())
                )
            }
            .wrapContentSize(Alignment.Center),
        color = Color.LightGray,
        strokeWidth = strokeWidth
    )
}