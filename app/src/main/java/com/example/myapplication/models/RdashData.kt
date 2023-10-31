package com.example.myapplication.models

data class RdashData(
    val code: Int,
    val data: List<Data>,
    val errors: Any,
    val message: String,
    val success: Boolean
)