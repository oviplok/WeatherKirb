package com.example.kotlinweather.repository.model.weatherapimodel

data class Sys(
    val country: String,
    val id: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
)