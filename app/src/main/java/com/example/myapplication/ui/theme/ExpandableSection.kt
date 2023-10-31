package com.example.myapplication.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.models.Data

@Composable
fun ExpandableSection1(
    layout2dData: MutableList<Data>,
    isExpanded: Boolean,
    onToggle: () -> Unit,
    title: String,
    uploadDate: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.clickable { onToggle() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Display section title and dropdown icon
            Text(
                text = "2D Layout/Adaptation",
                fontSize = 20.sp,
                modifier = Modifier.weight(1f)
            )
            DropdownIcon(isExpanded = isExpanded)
        }

        if (isExpanded) {
            // Display the content of the first section when expanded
            ElementCard(layout2dData, title, uploadDate)
        }
    }
}

@Composable
fun ExpandableSection2(
    isExpanded: Boolean,
    onToggle: () -> Unit,
    title: String,
    uploadDate: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.clickable { onToggle() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Display section title and dropdown icon
            Text(
                text = "3D Layout/Adaptation",
                fontSize = 20.sp,
                modifier = Modifier.weight(1f)
            )
            DropdownIcon(isExpanded = isExpanded)

        }

        if (isExpanded) {
            // Display the content of the second section when expanded
//            ElementCard(title, uploadDate)
        }
    }
}

@Composable
fun ExpandableSection3(
    isExpanded: Boolean,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Display section title and dropdown icon
            Text(
                text = "Production Files/ Artworks",
                fontSize = 20.sp,
                modifier = Modifier.weight(1f)
            )
            DropdownIcon(isExpanded = isExpanded)

        }
    }
}

@Composable
fun DropdownIcon(isExpanded: Boolean) {
    val icon: ImageVector = if (isExpanded) {
        Icons.Default.KeyboardArrowDown
    } else {
        Icons.Default.KeyboardArrowRight
    }

    Icon(
        imageVector = icon,
        contentDescription = null,
        modifier = Modifier.size(24.dp)
    )
}