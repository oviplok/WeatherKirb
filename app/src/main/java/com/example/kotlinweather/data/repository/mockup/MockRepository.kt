package com.example.kotlinweather.data.repository.mockup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.example.kotlinweather.data.model.DailyWeatherData
import com.example.kotlinweather.data.model.HourlyWeatherData
import com.example.kotlinweather.data.model.SettingsData
import com.example.kotlinweather.data.model.TodayWeatherData
import com.example.kotlinweather.data.repository.RepositoryActions
import java.sql.Timestamp

class MockRepository() : RepositoryActions {

    suspend fun getMockupWeatherInfo(): WeatherInfoMockup {
        return WeatherInfoMockup()
    }

    suspend fun getMockupSettings(): SettingsInfoMockup {
        return SettingsInfoMockup()
    }

    override fun getSettings(): LiveData<SettingsData> {
        val settings = MutableLiveData<SettingsData>() // Creating a MutableLiveData object

        // Setting the initial value for the settings object
        settings.value = SettingsData(
            city = SettingsInfoMockup().city,
            currentCity = SettingsInfoMockup().currentCity,
            lastUpdate = SettingsInfoMockup().lastUpdate
        )
        return settings
    }

    override fun getLastUpdate(): Timestamp {
        return SettingsInfoMockup().lastUpdate
    }

    override fun getCurrentCity(): String {
        return SettingsInfoMockup().city
    }

    override suspend fun insertSettings(settingsData: SettingsData) {}

    override suspend fun deleteSettings(settingsData: SettingsData) {}

    override suspend fun getTodayWeatherInfo(): LiveData<TodayWeatherData> {
    val todayWeather = MutableLiveData<TodayWeatherData>()

    todayWeather.value = TodayWeatherData(
        city = WeatherInfoMockup().city,
        currentTemperature = WeatherInfoMockup().currentTemperature,
        descriptionShort = WeatherInfoMockup().statusShort,
        descriptionLong = WeatherInfoMockup().statusLong)

    return todayWeather
    }

    override suspend fun deleteTodayWeather(todayWeatherData: TodayWeatherData) {}

    override suspend fun insertTodayWeather(weatherInfoData: TodayWeatherData) {}

//    @PrimaryKey
//    val dayName: String,
//    @PrimaryKey
//    val city: String,
//    @ColumnInfo
//    val minTemperature: Double,
//    @ColumnInfo
//    val maxTemperature: Double,
//    @ColumnInfo
//    val descriptionShort: String,
//    @ColumnInfo
//    val descriptionLong: String,
//    @ColumnInfo
//    val icon: String) {
    override suspend fun getDailyWeatherInfo(): LiveData<List<DailyWeatherData>> {
    val todayWeather = MutableLiveData<List<DailyWeatherData>>()

    todayWeather.value = WeatherInfoMockup().weekTemperatureList()

    return todayWeather
    }

    override suspend fun deleteDailyWeather(dailyWeatherData: DailyWeatherData) {}

    override suspend fun insertDailyWeather(dailyWeatherData: DailyWeatherData) {

    }

//    @PrimaryKey val dayName: String,
//    @PrimaryKey val city: String,
//    @ColumnInfo val minTemperature: Int,
//    @ColumnInfo val maxTemperature: Int,
//    @ColumnInfo val icon: String
    override suspend fun getHourlyWeatherInfo(): LiveData<List<HourlyWeatherData>> {
    val todayWeather = MutableLiveData<List<HourlyWeatherData>>()

    todayWeather.value = WeatherInfoMockup().hourTemperatureList()

    return todayWeather
    }

    override suspend fun deleteHourlyWeather(hourlyWeatherData: HourlyWeatherData) {}

    override suspend fun insertHourlyWeather(hourlyWeatherData: HourlyWeatherData) {}
}