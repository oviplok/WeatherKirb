package com.example.kotlinweather

import MainWeatherViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.example.kotlinweather.repository.model.WeatherInfoMockup
import com.example.kotlinweather.ui.navigation.MainScreen
import com.example.kotlinweather.ui.theme.KotlinWeatherTheme



class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val weatherInfoMockup = WeatherInfoMockup()


        WindowCompat.setDecorFitsSystemWindows(window,false)

        setContent {
            KotlinWeatherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                    //MainWeatherScreen(weatherInfoMockup)
                }
            }
        }

    }

}

