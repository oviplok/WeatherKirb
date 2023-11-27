package com.example.kotlinweather.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class DailyWeatherInfoData(@PrimaryKey val dayName: String,
                           @PrimaryKey val city: String,
                           @ColumnInfo val minTemperature: Double,
                           @ColumnInfo val maxTemperature: Double,
                           @ColumnInfo val descriptionShort: String,
                           @ColumnInfo val descriptionLong: String,
                           @ColumnInfo val icon: String) {
}