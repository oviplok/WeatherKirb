package com.example.kotlinweather.data.repository.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.kotlinweather.data.model.TodayWeatherData

@Dao
interface TodayWeatherDAO {
    @Query("SELECT * FROM TodayWeatherData WHERE city = (Select city from SettingsData where currentCity=1)")//(:settingsCity)"
    fun getTodayWeatherInfo(): LiveData<TodayWeatherData>//settingsCity: String

    @Upsert
    fun insertTodayWeatherInfo(vararg todayInfo: TodayWeatherData)

    @Delete
    fun deleteTodayWeatherInfo(todayWeatherData: TodayWeatherData)

    @Update
    fun updateTodayWeatherInfo(todayWeatherData: TodayWeatherData)

}