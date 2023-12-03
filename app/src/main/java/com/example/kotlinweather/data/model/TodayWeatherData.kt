package com.example.kotlinweather.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class TodayWeatherData(@ColumnInfo val currentTemperature: String,
                       @ColumnInfo val descriptionShort: String,
                       @ColumnInfo val descriptionLong: String,
                       @PrimaryKey val city: String
    ) {
}