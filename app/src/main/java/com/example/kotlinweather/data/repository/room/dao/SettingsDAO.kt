package com.example.kotlinweather.data.repository.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.kotlinweather.data.model.SettingsData
import java.sql.Timestamp


@Dao
interface SettingsDAO {
    @Query("Select * From SettingsData Where currentCity = 1")
    fun getCurrentSettings(): LiveData<SettingsData>

    @Query("Select city From SettingsData Where currentCity = 1")
    fun getCurrentCity(): String

    @Query("Select lastUpdate From SettingsData Where currentCity = 1")
    fun getLastUpdate(): Timestamp

    @Upsert
    fun insertSettings(vararg setting: SettingsData)

    @Delete
    fun deleteSettings(vararg setting: SettingsData)

    @Update
    fun updateSettings(vararg setting: SettingsData)


}