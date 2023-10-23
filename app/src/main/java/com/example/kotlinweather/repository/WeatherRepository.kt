package com.example.kotlinweather.repository

import com.example.kotlinweather.repository.model.WeatherInfoMockup

class WeatherRepository() {
    suspend fun getWeatherInfo(): WeatherInfoMockup {
        return WeatherInfoMockup()
    }
}