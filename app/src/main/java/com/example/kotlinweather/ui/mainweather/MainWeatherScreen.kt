package com.example.kotlinweather.ui.mainweather

import MainWeatherViewModel

import android.util.Log
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlinweather.R
import com.example.kotlinweather.repository.model.WeatherInfoMockup
import com.example.kotlinweather.ui.state.WeatherUiState
import com.example.kotlinweather.ui.theme.KotlinWeatherTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainWeatherScreen(
    //viewModel: MainWeatherViewModel,
    viewModel: MainWeatherViewModel = viewModel()
) {
    //val weatherUiState by viewModel.weatherUiState.observeAsState()

    val uiState: WeatherUiState = viewModel.weatherUiState
    Log.i("uiStatus: ",uiState.shortStatus)
    Log.i("uiStatus: ",uiState.currentHour.toString() )
//    val weatherInfoMockup: WeatherInfoMockup
//    val city: String = viewModel.city.toString()
//    val temperature: String = viewModel.temperature.toString()
//    val shortStatus: String = viewModel.shortStatus.toString()
//    val longStatus: String = viewModel.longStatus.toString()
//    val currentHour: Int= viewModel.currentHour.value!!.toInt()
//    val currentDay: Int = viewModel.currentDay.value!!.toInt()
//
//    val hourTList: List<String> = viewModel.hourTList.value!!.toList()
//    val  weekTList: List<WeatherInfoMockup.WeekTemperature> = viewModel.weekTList.value!!.toList()
//    val hourTList: List<String> = weatherInfoMockup.hourTemperatureList()
//    val weekTList: List<WeatherInfoMockup.WeekTemperature> = weatherInfoMockup.WeekTemperatureList()

    Column(modifier = Modifier
        .fillMaxWidth()
        .paint(
            painterResource(id = R.drawable.back_cloudy),
            contentScale = ContentScale.FillHeight
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){

        Text(
            text = uiState.city,
            color = Color.White,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(top = 20.dp))


        Text(text = uiState.temperature,
            fontSize = 100.sp,
            modifier = Modifier.padding(top = 15.dp),
            color = Color.White)

        Text(text = uiState.shortStatus,
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
                text = uiState.longStatus,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 10.dp)
            )

            Divider(color = Color(0x19FFFFFF),
                thickness = 1.dp,
                modifier = Modifier.padding(horizontal = 10.dp))

            var rep: Int = 0

            LazyRow {
                items(uiState.hourTList.size) { item ->
                    HourWeatherTab(item, uiState.currentHour, rep)
                    rep += 1

                }
            }
        }
           // weekListTab(uiState.weekTList)

    }
    //return MainWeatherScreen(weatherInfoMockup = weatherInfoMockup)
}






@Composable
fun weekListTab(weekTList: List<WeatherInfoMockup.WeekTemperature>) {
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
fun HourWeatherTab(item: Int, currentHour: Int, rep: Int) {
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
    val weatherViewModel: MainWeatherViewModel = viewModel()

    KotlinWeatherTheme {
        MainWeatherScreen(
            weatherViewModel
        )
    }
}