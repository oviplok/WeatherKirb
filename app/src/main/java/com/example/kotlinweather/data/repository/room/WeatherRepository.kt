package com.example.kotlinweather.data.repository.room

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.kotlinweather.data.repository.RepositoryActions
import com.example.kotlinweather.data.repository.mockup.SettingsInfoMockup
import com.example.kotlinweather.data.repository.mockup.WeatherInfoMockup
import com.example.kotlinweather.data.model.DailyWeatherData
import com.example.kotlinweather.data.model.HourlyWeatherData
import com.example.kotlinweather.data.model.SettingsData
import com.example.kotlinweather.data.model.TodayWeatherData
import com.example.kotlinweather.data.repository.room.dao.DailyWeatherDAO
import com.example.kotlinweather.data.repository.room.dao.HourlyWeatherDAO
import com.example.kotlinweather.data.repository.room.dao.SettingsDAO
import com.example.kotlinweather.data.repository.room.dao.TodayWeatherDAO
import java.sql.Timestamp

public class WeatherRepository(application: Application) : RepositoryActions {
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
//    suspend fun getMockupWeatherInfo(): WeatherInfoMockup {
//        return WeatherInfoMockup()
//    }
//
//    suspend fun getMockupSettings(): SettingsInfoMockup {
//        return SettingsInfoMockup()
//    }

    //Settings---------------------------------------------------------------------
    override fun getSettings(): LiveData<SettingsData> {
        return settingsDAO.getCurrentSettings();
    }

    override fun getLastUpdate(): Timestamp{
        return settingsDAO.getLastUpdate()
    }

    override fun getCurrentCity(): String {
        return settingsDAO.getCurrentCity()
    }

    override suspend fun insertSettings(settingsData: SettingsData){
        settingsDAO.insertSettings(settingsData)
    }

//    suspend fun updateSettings(settingsData: SettingsData){
//        settingsDAO.updateSettings(settingsData)
//    }

    override suspend fun deleteSettings(settingsData: SettingsData){
        settingsDAO.deleteSettings(settingsData)
    }

    //Today---------------------------------------------------------------------
    override suspend fun getTodayWeatherInfo(): LiveData<TodayWeatherData> {
        return todayWeatherDAO.getTodayWeatherInfo()
    }

    override suspend fun deleteTodayWeather(todayWeatherData: TodayWeatherData){
        todayWeatherDAO.deleteTodayWeatherInfo(todayWeatherData)
    }

//    suspend fun updateTodayWeather(weatherInfoData: TodayWeatherInfoData){
//        todayWeatherDAO.updateTodayWeatherInfo(weatherInfoData)
//    }

    override suspend fun insertTodayWeather(weatherInfoData: TodayWeatherData){
        todayWeatherDAO.insertTodayWeatherInfo()
    }

    //Daily---------------------------------------------------------------------
    override suspend fun getDailyWeatherInfo(): LiveData<List<DailyWeatherData>>{
        return dailyWeatherDAO.getDailyWeatherInfo()
    }

    override suspend fun deleteDailyWeather(dailyWeatherData: DailyWeatherData){
        dailyWeatherDAO.deleteDailyWeatherInfo(dailyWeatherData)
    }

//    suspend fun updateDailyWeather(dailyWeatherInfoData: DailyWeatherInfoData){
//        dailyWeatherDAO.updateDailyWeatherInfo(dailyWeatherInfoData)
//    }

    override suspend fun insertDailyWeather(dailyWeatherData: DailyWeatherData){
        dailyWeatherDAO.insertDailyWeatherInfo(dailyWeatherData)
    }

    //Hourly---------------------------------------------------------------------
    override suspend fun getHourlyWeatherInfo(): LiveData<List<HourlyWeatherData>>{
        return hourlyWeatherDAO.getHourlyWeatherInfo()
    }

    override suspend fun deleteHourlyWeather(hourlyWeatherData: HourlyWeatherData){
        hourlyWeatherDAO.deleteHourlyWeatherInfo(hourlyWeatherData)
    }

//    suspend fun updateHourlyWeather(hourlyWeatherInfoData: HourlyWeatherInfoData){
//        hourlyWeatherDAO.updateHourlyWeatherInfo(hourlyWeatherInfoData)
//    }

    override suspend fun insertHourlyWeather(hourlyWeatherData: HourlyWeatherData){
        hourlyWeatherDAO.insertHourlyWeatherInfo(hourlyWeatherData)
    }
}
