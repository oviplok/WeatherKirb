package com.example.kotlinweather.repository.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kotlinweather.repository.model.DailyWeatherInfoData
import com.example.kotlinweather.repository.model.HourlyWeatherInfoData
import com.example.kotlinweather.repository.model.TodayWeatherInfoData

@Dao
interface HourlyWeatherDAO {

    @Query("SELECT * FROM HourlyWeatherInfoData WHERE city = (Select city from SettingsData where currentCity=1)")//(:settingsCity)"
    fun getHourlyWeatherInfo(): LiveData<List<HourlyWeatherInfoData>>//settingsCity: String

    @Insert
    fun insertHourlyWeatherInfo(vararg todayInfo: HourlyWeatherInfoData)

    @Delete
    fun deleteHourlyWeatherInfo(hourlyWeatherInfoData: HourlyWeatherInfoData)

    @Update
    fun updateHourlyWeatherInfo(hourlyWeatherInfoData: HourlyWeatherInfoData)

}