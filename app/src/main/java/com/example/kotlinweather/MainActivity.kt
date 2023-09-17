package com.example.kotlinweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinweather.data.WeatherInfo
import com.example.kotlinweather.mainweatherscreen.MainWeatherScreen
import com.example.kotlinweather.ui.theme.KotlinWeatherTheme
import kotlin.random.Random


//val rightNow = Calendar.getInstance()
//val currentHOUR: Int = rightNow.get(Calendar.HOUR_OF_DAY)
//val currentDAY: Int = rightNow.get(Calendar.DAY_OF_MONTH)
//val StatusShort: String = "Mostly Sunny"
//val StatusLong: String = "Sunny Condition will continue all day. Wind gusts are up to 7 mph."

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val weatherInfo = WeatherInfo()

        weatherInfo.StatusShort = "Mostly Sunny"
        weatherInfo.StatusLong = "Sunny Condition will continue all day. Wind gusts are up to 7 mph."
        setContent {
            KotlinWeatherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainWeatherScreen("Moscow",
                        "+21",
                        weatherInfo.StatusShort,
                        weatherInfo.StatusLong,
                        weatherInfo.currentHOUR,
                        weatherInfo.currentHOUR,
                        temeperatureHourList())
                }
            }
        }
    }

    private fun temeperatureHourList(): MutableList<String> {
        val list = mutableListOf<String>() // Create an empty list to store the decimal numbers

        // Add 24 random decimal numbers to the list
        repeat(24) {
            val randomDecimal = Random.nextDouble()
            list.add(randomDecimal.toInt().toString())
        }
        return list
    }
}

