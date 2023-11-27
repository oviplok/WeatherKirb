package com.example.kotlinweather.ui.navigation

import MainWeatherViewModel
import androidx.compose.runtime.Composable

import androidx.activity.viewModels
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinweather.ui.mainweather.MainWeatherScreen
import com.example.kotlinweather.ui.settings.Settings
import com.example.kotlinweather.viewmodel.SettingsViewModel


@Composable
fun NavGraph(navHostController: NavHostController) {
    val navController = rememberNavController()

//    val weatherViewModel = hiltViewModel<MainWeatherViewModel>()
//    val settingsViewModel = hiltViewModel<SettingsViewModel>()
    val weatherViewModel: MainWeatherViewModel = viewModel()
    val settingsViewModel: SettingsViewModel = viewModel()

    NavHost(navController = navHostController, startDestination = "weather" ){

        composable("weather"){
            MainWeatherScreen(weatherViewModel)
        }
        composable("settings"){
            Settings(settingsViewModel)
        }
    }
}