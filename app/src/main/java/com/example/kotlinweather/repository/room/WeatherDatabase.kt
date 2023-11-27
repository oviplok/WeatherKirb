package com.example.kotlinweather.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlinweather.repository.model.DailyWeatherInfoData
import com.example.kotlinweather.repository.model.HourlyWeatherInfoData
import com.example.kotlinweather.repository.model.SettingsData
import com.example.kotlinweather.repository.model.TodayWeatherInfoData
import com.example.kotlinweather.repository.room.dao.DailyWeatherDAO
import com.example.kotlinweather.repository.room.dao.HourlyWeatherDAO
import com.example.kotlinweather.repository.room.dao.SettingsDAO
import com.example.kotlinweather.repository.room.dao.TodayWeatherDAO


@Database(entities = [SettingsData::class,
    TodayWeatherInfoData::class,
    DailyWeatherInfoData::class,
    HourlyWeatherInfoData::class],
    version = 1, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase()  {
    abstract fun hourlyWeatherDAO(): HourlyWeatherDAO
    abstract fun dailyWeatherDAO(): DailyWeatherDAO
    abstract fun todayWeatherDAO(): TodayWeatherDAO
    abstract fun settingsDAO(): SettingsDAO

//    public static WeatherDatabase getInstance(){
//
//    }


}