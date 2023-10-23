package com.example.kotlinweather.repository.model.weatherapimodel

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)