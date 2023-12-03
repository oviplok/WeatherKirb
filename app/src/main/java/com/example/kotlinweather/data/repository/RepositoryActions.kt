package com.example.kotlinweather.data.repository

import androidx.lifecycle.LiveData
import com.example.kotlinweather.data.model.DailyWeatherData
import com.example.kotlinweather.data.model.HourlyWeatherData
import com.example.kotlinweather.data.model.SettingsData
import com.example.kotlinweather.data.model.TodayWeatherData
import java.sql.Timestamp

interface RepositoryActions {
    fun getSettings(): LiveData<SettingsData>
    fun getLastUpdate(): Timestamp
    fun getCurrentCity(): String
    suspend fun insertSettings(settingsData: SettingsData)
    suspend fun deleteSettings(settingsData: SettingsData)
    suspend fun getTodayWeatherInfo(): LiveData<TodayWeatherData>
    suspend fun deleteTodayWeather(todayWeatherData: TodayWeatherData)
    suspend fun insertTodayWeather(weatherInfoData: TodayWeatherData)
    suspend fun getDailyWeatherInfo(): LiveData<List<DailyWeatherData>>
    suspend fun deleteDailyWeather(dailyWeatherData: DailyWeatherData)
    suspend fun insertDailyWeather(dailyWeatherData: DailyWeatherData)
    suspend fun getHourlyWeatherInfo(): LiveData<List<HourlyWeatherData>>
    suspend fun deleteHourlyWeather(hourlyWeatherData: HourlyWeatherData)
    suspend fun insertHourlyWeather(hourlyWeatherData: HourlyWeatherData)
}