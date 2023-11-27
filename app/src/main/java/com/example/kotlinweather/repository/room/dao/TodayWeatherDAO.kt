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
interface TodayWeatherDAO {
    @Query("SELECT * FROM TodayWeatherInfoData WHERE city = (Select city from SettingsData where currentCity=1)")//(:settingsCity)"
    fun getTodayWeatherInfo(): LiveData<TodayWeatherInfoData>//settingsCity: String

    @Insert
    fun insertTodayWeatherInfo(vararg todayInfo: TodayWeatherInfoData)

    @Delete
    fun deleteTodayWeatherInfo(todayWeatherInfoData: TodayWeatherInfoData)

    @Update
    fun updateTodayWeatherInfo(todayWeatherInfoData: TodayWeatherInfoData)

}