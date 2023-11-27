package com.example.kotlinweather.repository.room

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.kotlinweather.repository.mockup.SettingsDataMockup
import com.example.kotlinweather.repository.mockup.WeatherInfoMockup
import com.example.kotlinweather.repository.model.DailyWeatherInfoData
import com.example.kotlinweather.repository.model.HourlyWeatherInfoData
import com.example.kotlinweather.repository.model.SettingsData
import com.example.kotlinweather.repository.model.TodayWeatherInfoData
import com.example.kotlinweather.repository.room.dao.DailyWeatherDAO
import com.example.kotlinweather.repository.room.dao.HourlyWeatherDAO
import com.example.kotlinweather.repository.room.dao.SettingsDAO
import com.example.kotlinweather.repository.room.dao.TodayWeatherDAO
import java.sql.Timestamp
import java.util.Date

public class WeatherRepository(application: Application) {
    private val todayWeatherDAO: TodayWeatherDAO
    private val dailyWeatherDAO: DailyWeatherDAO
    private val hourlyWeatherDAO: HourlyWeatherDAO
    private val settingsDAO: SettingsDAO

    init {
        val db = Room.databaseBuilder(
            application,
            WeatherDatabase::class.java, "database-weather"
        ).build()
        dailyWeatherDAO = db.dailyWeatherDAO()
        hourlyWeatherDAO = db.hourlyWeatherDAO()
        todayWeatherDAO = db.todayWeatherDAO()
        settingsDAO = db.settingsDAO()

    }

    //Mockup---------------------------------------------------------------------
    suspend fun getMockupWeatherInfo(): WeatherInfoMockup {
        return WeatherInfoMockup()
    }

    suspend fun getMockupSettings(): SettingsDataMockup {
        return SettingsDataMockup()
    }

    //Settings---------------------------------------------------------------------
    fun getSettings(): LiveData<SettingsData> {
        return settingsDAO.getCurrentSettings();
    }

    fun getLastUpdate(): Timestamp{
        return settingsDAO.getLastUpdate()
    }

    fun getCurrentCity(): String {
        return settingsDAO.getCurrentCity()
    }

    suspend fun insertSettings(settingsData: SettingsData){
        settingsDAO.insertSettings(settingsData)
    }

    suspend fun updateSettings(settingsData: SettingsData){
        settingsDAO.updateSettings(settingsData)
    }

    suspend fun deleteSettings(settingsData: SettingsData){
        settingsDAO.deleteSettings(settingsData)
    }

    //Today---------------------------------------------------------------------
    suspend fun getTodayWeatherInfo(): LiveData<TodayWeatherInfoData> {
        return todayWeatherDAO.getTodayWeatherInfo()
    }

    suspend fun deleteTodayWeather(todayWeatherInfoData: TodayWeatherInfoData){
        todayWeatherDAO.deleteTodayWeatherInfo(todayWeatherInfoData)
    }

    suspend fun updateTodayWeather(weatherInfoData: TodayWeatherInfoData){
        todayWeatherDAO.updateTodayWeatherInfo(weatherInfoData)
    }

    suspend fun insertTodayWeather(weatherInfoData: TodayWeatherInfoData){
        todayWeatherDAO.insertTodayWeatherInfo()
    }

    //Daily---------------------------------------------------------------------
    suspend fun getDailyWeatherInfo(): LiveData<List<DailyWeatherInfoData>>{
        return dailyWeatherDAO.getDailyWeatherInfo()
    }

    suspend fun deleteDailyWeather(dailyWeatherInfoData: DailyWeatherInfoData){
        dailyWeatherDAO.deleteDailyWeatherInfo(dailyWeatherInfoData)
    }

    suspend fun updateDailyWeather(dailyWeatherInfoData: DailyWeatherInfoData){
        dailyWeatherDAO.updateDailyWeatherInfo(dailyWeatherInfoData)
    }

    suspend fun insertDailyWeather(dailyWeatherInfoData: DailyWeatherInfoData){
        dailyWeatherDAO.insertDailyWeatherInfo(dailyWeatherInfoData)
    }

    //Hourly---------------------------------------------------------------------
    suspend fun getHourlyWeatherInfo(): LiveData<List<HourlyWeatherInfoData>>{
        return hourlyWeatherDAO.getHourlyWeatherInfo()
    }

    suspend fun deleteHourlyWeather(hourlyWeatherInfoData: HourlyWeatherInfoData){
        hourlyWeatherDAO.deleteHourlyWeatherInfo(hourlyWeatherInfoData)
    }

    suspend fun updateHourlyWeather(hourlyWeatherInfoData: HourlyWeatherInfoData){
        hourlyWeatherDAO.updateHourlyWeatherInfo(hourlyWeatherInfoData)
    }

    suspend fun insertHourlyWeather(hourlyWeatherInfoData: HourlyWeatherInfoData){
        hourlyWeatherDAO.insertHourlyWeatherInfo(hourlyWeatherInfoData)
    }
}
