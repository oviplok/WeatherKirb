package com.example.kotlinweather.repository.model

class SettingsData {
    var city: String = "Moscow"
        get() {
            return field
        }
        set(value) {
            field = value
        }
}