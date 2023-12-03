package com.example.kotlinweather.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.security.Timestamp

@Entity
class SettingsData(@PrimaryKey var city: String,
                   @ColumnInfo val currentCity: Boolean,
                   @ColumnInfo val lastUpdate: java.sql.Timestamp
)

//@Entity
//data class User(
//    @PrimaryKey val uid: Int,
//    @ColumnInfo(name = "first_name") val firstName: String?,
//    @ColumnInfo(name = "last_name") val lastName: String?
//)