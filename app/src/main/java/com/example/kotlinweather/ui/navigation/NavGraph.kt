package com.example.kotlinweather.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlinweather.data.WeatherInfoMockup
import com.example.kotlinweather.ui.mainweather.MainWeatherScreen
import com.example.kotlinweather.ui.settings.Settings

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "weather" ){
        composable("weather"){
            MainWeatherScreen(weatherInfoMockup = WeatherInfoMockup())
        }
        composable("settings"){
            Settings()
        }
    }
}