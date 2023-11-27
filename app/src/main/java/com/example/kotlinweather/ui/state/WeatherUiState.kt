package com.example.kotlinweather.ui.state

import com.example.kotlinweather.repository.mockup.WeatherInfoMockup

data class  WeatherUiState(
    var city: String = "Moscow",
    val temperature: String = "21",
    val shortStatus: String = "Meh meh",
    val longStatus: String = "Meh meh meh",
    val currentHour: Int = 12,
    val currentDay: Int = 13,
    val hourTList: List<String> = listOf("1","2","3","4","5","6"),
    val weekTList: List<WeatherInfoMockup.WeekTemperature> = listOf(WeatherInfoMockup.WeekTemperature())){

    //val weatherRepository: WeatherRepository = WeatherRepository()
}