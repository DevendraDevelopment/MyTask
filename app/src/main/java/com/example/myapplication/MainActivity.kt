package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.TabRowDefaults.Indicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.ExpandableSection1
import com.example.myapplication.ui.theme.ExpandableSection2
import com.example.myapplication.ui.theme.ExpandableSection3
import com.example.myapplication.ui.theme.LoaderIndicator
import com.example.myapplication.ui.theme.MainViewModel
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Pink40
import com.example.myapplication.ui.theme.Toolbar
import com.example.myapplication.ui.theme.strokeWidth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Toolbar(title = "Hello")
                    Spacer(modifier = Modifier.height(10.dp))
                    if (viewModel.layout2dData.isEmpty()) {
                        LoaderIndicator()
                    } else {
                        ExpandableSection1(
                            viewModel.layout2dData,
                            isExpanded = viewModel.section1Expanded.value,
                            onToggle = { viewModel.toggleSection1() },
                            title = "viewModel.title",
                            uploadDate = "viewModel.uploadDat"
                        )
                    }
                    ExpandableSection2(
                        isExpanded = viewModel.section2Expanded.value,
                        onToggle = { viewModel.toggleSection2() },
                        title = " viewModel.title",
                        uploadDate = "viewModel.uploadDate"
                    )
                    ExpandableSection3(
                        isExpanded = viewModel.section3Expanded.value
                    )
                }
            }
        }
    }
}
