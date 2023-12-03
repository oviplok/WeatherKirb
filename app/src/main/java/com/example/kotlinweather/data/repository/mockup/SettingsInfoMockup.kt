package com.example.kotlinweather.data.repository.mockup

import java.sql.Timestamp

class SettingsInfoMockup {
    var city: String = "Moscow"
    var currentCity: Boolean = true
    var lastUpdate: Timestamp = Timestamp(System.currentTimeMillis())
}


