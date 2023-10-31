package com.example.myapplication.ui.theme

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.myapplication.api.ApiService
import com.example.myapplication.di.Network
import com.example.myapplication.models.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private lateinit var apiService: ApiService

    val section1Expanded = mutableStateOf(false)
    val section2Expanded = mutableStateOf(false)
    val section3Expanded = mutableStateOf(false)

    var layout2dData = mutableStateListOf<Data>()
    var layout3dData = mutableStateListOf<Data>()
    var layoutProdData = mutableStateListOf<Data>()

    init {
        getData(layout2dData, layout3dData, layoutProdData)
    }

    private fun getData(
        layout2dData: MutableList<Data>,
        layout3dData: MutableList<Data>,
        layoutProdData: MutableList<Data>
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                apiService = Network().providersRetrofit().create(ApiService::class.java)
                val response = apiService.callWebhook()
                if (response.isSuccessful) {
                    val data = response.body()
                    Log.e("SER_RESPONSE", data.toString())

                    // Process the data as needed, e.g., update UI or store it in ViewModel
                    if (data != null) {
                        for (items in data.data) {
                            when (items.section) {
                                "2D" -> {
                                    layout2dData.add(items)
                                }

                                "3D" -> {
                                    layout3dData.add(items)
                                }

                                else -> {
                                    layoutProdData.add(items)
                                }
                            }
                        }
                        //                        val title = data.data[0].name
                        //                        val uploadDate = data.data[0].uploaded_at
                        // Update the UI or ViewModel with title and uploadDate
                        //                        viewModel.updateTitleAndUploadDate(title, uploadDate)
                    }
                } else {
                    // Handle API error (response code other than 2xx)
                    Log.e("SER_RESPONSE", "API Error: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                // Handle network or other exceptions
                Log.e("SER_RESPONSE", "Network Error: ${e.message}", e)
            }
        }
    }

    fun toggleSection1() {
        section1Expanded.value = !section1Expanded.value
    }

    fun toggleSection2() {
        section2Expanded.value = !section2Expanded.value
    }

    fun toggleSection3() {
        section3Expanded.value = !section3Expanded.value
    }
}
