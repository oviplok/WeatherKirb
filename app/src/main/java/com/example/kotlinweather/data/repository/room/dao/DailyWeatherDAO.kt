package com.example.kotlinweather.data.repository.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.kotlinweather.data.model.DailyWeatherData

@Dao
interface DailyWeatherDAO {

    @Query("SELECT * FROM DailyWeatherData WHERE city = (Select city from SettingsData where currentCity=1)")//(:settingsCity)"
    fun getDailyWeatherInfo(): LiveData<List<DailyWeatherData>>//settingsCity: String

    @Upsert
    fun insertDailyWeatherInfo(dailyWeatherInfo: DailyWeatherData)

    @Delete
    fun deleteDailyWeatherInfo(dailyWeatherData: DailyWeatherData)

    @Update
    fun updateDailyWeatherInfo(dailyWeatherData: DailyWeatherData)

}