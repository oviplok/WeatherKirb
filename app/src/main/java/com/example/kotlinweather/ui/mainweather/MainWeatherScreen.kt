package com.example.kotlinweather.ui.mainweather

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinweather.R
import com.example.kotlinweather.data.WeatherInfoMockup
import com.example.kotlinweather.ui.theme.KotlinWeatherTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainWeatherScreen(
    weatherInfoMockup: WeatherInfoMockup,
) {
    val city: String = weatherInfoMockup.city.toString()
    val temperature: String = weatherInfoMockup.currentTemperature
    val shortStatus: String = weatherInfoMockup.statusShort
    val longStatus: String = weatherInfoMockup.statusLong
    val currentHour: Int=  weatherInfoMockup.currentHOUR
    val currentDay: Int = weatherInfoMockup.currentDAY
    val hourTList: MutableList<String> = weatherInfoMockup.hourTemperatureList()
    val weekTList: MutableList<WeatherInfoMockup.WeekTemperature> = weatherInfoMockup.WeekTemperatureList()

    Column(modifier = Modifier
        .fillMaxWidth()
        .paint(
            painterResource(id = R.drawable.back_cloudy),
            contentScale = ContentScale.FillHeight
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){

        Text(
            text = city,
            color = Color.White,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(top = 20.dp))


        Text(text = temperature,
            fontSize = 100.sp,
            modifier = Modifier.padding(top = 15.dp),
            color = Color.White)

        Text(text = shortStatus,
            fontSize = 25.sp,
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

            Divider(color = Color(0x19FFFFFF),
                thickness = 1.dp,
                modifier = Modifier.padding(horizontal = 10.dp))

            var rep: Int = 0

            LazyRow {
                items(hourTList) { item ->
                    HourWeatherTab(item, currentHour, rep)
                    rep += 1

                }
            }
        }
            weekListTab(weekTList)

    }
    //return MainWeatherScreen(weatherInfoMockup = weatherInfoMockup)
}






@Composable
fun weekListTab(weekTList: MutableList<WeatherInfoMockup.WeekTemperature>) {
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

        Divider(color = Color(0x19FFFFFF),
            thickness = 1.dp,
            modifier = Modifier.padding(horizontal = 10.dp))

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp),
            //horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            repeat(7)
            {rowIndex ->
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                    ) {

                    Text(text = weekTList[rowIndex].dayName,
                        color = Color.White,)

                    Image(
                        painterResource(id = R.drawable.sun),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp, 40.dp)
                            .padding(start = 10.dp)
                    )

                    Text(text = weekTList[rowIndex].minTemperature.toString()
                            +"/"+weekTList[rowIndex].maxTemperature.toString(),
                        color = Color(0x80FFFFFF),
                        modifier = Modifier
                            .padding(horizontal = 10.dp),
                        textAlign = TextAlign.Center)
                }

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

        Text(text = hour+"h",
            color = Color.White)

        Image(
            painterResource(id = R.drawable.sun),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp, 40.dp)
                .padding(vertical = 5.dp))

        Text(text = "+$item",
            color = Color.White)

    }
}


@Preview(showBackground = true)
@Composable
fun MainWeatherScreenPreview() {
    val weatherInfoMockup = WeatherInfoMockup()

    KotlinWeatherTheme {
        MainWeatherScreen(
            weatherInfoMockup
//            weatherInfoMockup.city,
//            weatherInfoMockup.currentTemperature,
//            weatherInfoMockup.statusShort,
//            weatherInfoMockup.statusLong,
//            weatherInfoMockup.currentHOUR,
//            weatherInfoMockup.currentHOUR,
//            weatherInfoMockup.hourTemperatureList(),
//            weatherInfoMockup.WeekTemperatureList()
        )
    }
}