package com.example.myapplication.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.models.Data
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ElementCard(layout2dData: MutableList<Data>, title:String, uploadDate:String) {
    LazyColumn {
        items(layout2dData) { it ->
            Card(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                ), modifier = Modifier.padding(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pdf),
                        contentDescription = "",
                        modifier = Modifier
                            .size(48.dp)
                            .padding(8.dp)
                    )

                    Column(modifier = Modifier.weight(.7f)) {
                        Text(
                            text = it.name,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Uploaded on: "+changeDate(it.uploaded_at) ,
                            style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Thin
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.dots),
                        contentDescription = "",
                        modifier = Modifier
                            .size(40.dp)
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun changeDate(date: String): String {
    val originalFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.getDefault())
    val targetFormat: DateFormat = SimpleDateFormat("dd MMM, yy HH:mmaa", Locale.getDefault())
    val reqDate: Date = originalFormat.parse(date)!!
    return targetFormat.format(reqDate)
}


