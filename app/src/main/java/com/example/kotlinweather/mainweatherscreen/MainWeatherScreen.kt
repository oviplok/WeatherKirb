package com.example.kotlinweather.mainweatherscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinweather.R
import com.example.kotlinweather.data.WeatherInfo
import com.example.kotlinweather.ui.theme.KotlinWeatherTheme
import kotlin.random.Random


@Composable
fun MainWeatherScreen(
    city: String,
    temperature: String,
    shortStatus: String,
    longStatus: String,
    currentHour: Int,
    currentDay: Int,
    hourTList: MutableList<String>
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .paint(
            painterResource(id = R.drawable.back),
            contentScale = ContentScale.FillHeight
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = city,
            color = Color.White,
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 20.dp))
        Text(text = temperature,
            fontSize = 100.sp,
            modifier = Modifier
                .padding(top = 15.dp),
            color = Color.White)
        Text(text = shortStatus,
            fontSize = 30.sp,
            modifier = Modifier,
            color = Color.White)
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 15.dp)
            .background(
                shape = RoundedCornerShape(10.dp),
                color = Color(0xFF00A6FF)
            )
        ) {
            Text(
                text = longStatus,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            var rep: Int = 0
            LazyRow {
                items(hourTList) { item ->
                    HourWeatherTab(item, currentHour, rep)
                    rep += 1

                }
            }
        }

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 15.dp)
                .background(
                    shape = RoundedCornerShape(10.dp),
                    color = Color(0xFF00A6FF)
                )){
                Text(text = "7-DAY FORECAST",
                    color = Color(0x80FFFFFF),
                    modifier = Modifier.padding(horizontal = 10.dp))
                LazyColumn{
                    TODO()
                }
                
            }
    }
}

@Composable
fun HourWeatherTab(item: String, currentHour: Int, rep: Int) {
    val hour = if (currentHour + rep > 24) {
        rep.toString()
    } else {
        (currentHour + rep).toString()
    }
    Column(modifier = Modifier.padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = hour,
            color = Color.White)
        Image(
            painterResource(id = R.drawable.sun),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp, 40.dp)
                .padding(vertical = 5.dp))
        Text(text = item,
            color = Color.White)

    }
}


@Preview(showBackground = true)
@Composable
fun MainWeatherScreenPreview() {
    val weatherInfo = WeatherInfo()

    weatherInfo.StatusShort = "Mostly Sunny"
    weatherInfo.StatusLong = "Sunny Condition will continue all day. Wind gusts are up to 7 mph."
    KotlinWeatherTheme {
        MainWeatherScreen("Moscow",
            "+21",
            weatherInfo.StatusShort,
            weatherInfo.StatusLong,
            weatherInfo.currentHOUR,
            weatherInfo.currentHOUR,
            weatherInfo.hourTempList())
    }
}