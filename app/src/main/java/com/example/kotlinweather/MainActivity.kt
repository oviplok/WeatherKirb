package com.example.kotlinweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.kotlinweather.data.WeatherInfoMockup
import com.example.kotlinweather.mainweatherscreen.MainWeatherScreen
import com.example.kotlinweather.ui.theme.KotlinWeatherTheme




class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val weatherInfoMockup = WeatherInfoMockup()

        setContent {
            KotlinWeatherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainWeatherScreen(weatherInfoMockup.city,
                        weatherInfoMockup.currentTemperature,
                        weatherInfoMockup.statusShort,
                        weatherInfoMockup.statusLong,
                        weatherInfoMockup.currentHOUR,
                        weatherInfoMockup.currentHOUR,
                        weatherInfoMockup.hourTemperatureList(),
                        weatherInfoMockup.WeekTemperatureList())
                }
            }
        }
    }

//    private fun temeperatureHourList(): MutableList<String> {
//        val list = mutableListOf<String>() // Create an empty list to store the decimal numbers
//
//        // Add 24 random decimal numbers to the list
//        repeat(24) {
//            val randomDecimal = Random.nextDouble()
//            list.add(randomDecimal.toInt().toString())
//        }
//        return list
//    }
}

