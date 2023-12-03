package com.example.kotlinweather.data.model.weatherapi

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)