package com.example.myapplication.di

import com.example.myapplication.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Network {
    @Singleton
    @Provides
    fun providersRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://n8n.rdash.io/") // Replace with your base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRdashApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}