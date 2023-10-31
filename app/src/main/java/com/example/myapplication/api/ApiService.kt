package com.example.myapplication.api

import com.example.myapplication.models.RdashData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("webhook/223a7fe0-4e32-4414-aacf-1bc0ab1c0bba")
    suspend fun callWebhook(): Response<RdashData>
}