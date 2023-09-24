package com.example.kotlinweather.ui.navigation

import com.example.kotlinweather.R

sealed class BottomItem(val title: String, val iconId: Int, val route: String) {
    object MainWeatherScreen: BottomItem("Weather", R.drawable.ic_action_weather,"weather")
    object SettingsScreen: BottomItem("Settings", R.drawable.ic_action_settings,"settings")
}