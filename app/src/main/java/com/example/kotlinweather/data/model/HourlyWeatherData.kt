package com.example.kotlinweather.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class HourlyWeatherData(@PrimaryKey val time: Int,
                        @PrimaryKey val city: String,
                        @ColumnInfo val minTemperature: Int,
                        @ColumnInfo val maxTemperature: Int,
//                        @ColumnInfo val descriptionShort: String,
//                        @ColumnInfo val descriptionLong: String,
                        @ColumnInfo val icon: String) {
}