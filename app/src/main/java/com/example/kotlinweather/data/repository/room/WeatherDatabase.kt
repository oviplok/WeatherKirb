package com.example.kotlinweather.data.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlinweather.data.model.DailyWeatherData
import com.example.kotlinweather.data.model.HourlyWeatherData
import com.example.kotlinweather.data.model.SettingsData
import com.example.kotlinweather.data.model.TodayWeatherData
import com.example.kotlinweather.data.repository.room.dao.DailyWeatherDAO
import com.example.kotlinweather.data.repository.room.dao.HourlyWeatherDAO
import com.example.kotlinweather.data.repository.room.dao.SettingsDAO
import com.example.kotlinweather.data.repository.room.dao.TodayWeatherDAO


@Database(entities = [SettingsData::class,
    TodayWeatherData::class,
    DailyWeatherData::class,
    HourlyWeatherData::class],
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