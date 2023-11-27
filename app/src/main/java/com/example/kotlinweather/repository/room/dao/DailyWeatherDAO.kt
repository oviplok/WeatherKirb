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
interface DailyWeatherDAO {

    @Query("SELECT * FROM DailyWeatherInfoData WHERE city = (Select city from SettingsData where currentCity=1)")//(:settingsCity)"
    fun getDailyWeatherInfo(): LiveData<List<DailyWeatherInfoData>>//settingsCity: String

    @Insert
    fun insertDailyWeatherInfo(dailyWeatherInfo: DailyWeatherInfoData)

    @Delete
    fun deleteDailyWeatherInfo(dailyWeatherInfoData: DailyWeatherInfoData)

    @Update
    fun updateDailyWeatherInfo(dailyWeatherInfoData: DailyWeatherInfoData)

}