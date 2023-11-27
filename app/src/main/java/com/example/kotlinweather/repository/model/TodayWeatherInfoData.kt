package com.example.kotlinweather.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class TodayWeatherInfoData(@ColumnInfo val currentTemperature: String,
                           @ColumnInfo val descriptionShort: String,
                           @ColumnInfo val descriptionLong: String,
                           @PrimaryKey val city: String
    ) {
}