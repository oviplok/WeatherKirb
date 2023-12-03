package com.example.kotlinweather.data.repository.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.kotlinweather.data.model.HourlyWeatherData

@Dao
interface HourlyWeatherDAO {

    @Query("SELECT * FROM HourlyWeatherData WHERE city = (Select city from SettingsData where currentCity=1)")//(:settingsCity)"
    fun getHourlyWeatherInfo(): LiveData<List<HourlyWeatherData>>//settingsCity: String

    @Upsert
    fun insertHourlyWeatherInfo(vararg todayInfo: HourlyWeatherData)

    @Delete
    fun deleteHourlyWeatherInfo(hourlyWeatherData: HourlyWeatherData)

    @Update
    fun updateHourlyWeatherInfo(hourlyWeatherData: HourlyWeatherData)

}