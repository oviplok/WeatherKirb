package com.example.kotlinweather.repository.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kotlinweather.repository.model.SettingsData
import com.example.kotlinweather.repository.model.TodayWeatherInfoData
import java.sql.Timestamp


@Dao
interface SettingsDAO {
    @Query("Select * From SettingsData Where currentCity = 1")
    fun getCurrentSettings(): LiveData<SettingsData>

    @Query("Select city From SettingsData Where currentCity = 1")
    fun getCurrentCity(): String

    @Query("Select lastUpdate From SettingsData Where currentCity = 1")
    fun getLastUpdate(): Timestamp

    @Insert
    fun insertSettings(vararg setting: SettingsData)

    @Delete
    fun deleteSettings(vararg setting: SettingsData)

    @Update
    fun updateSettings(vararg setting: SettingsData)


}