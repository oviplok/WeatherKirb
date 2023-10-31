package com.example.kotlinweather.repository.model

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Calendar
import java.util.Locale
import kotlin.random.Random

class WeatherInfoMockup {
    private var settingsData = SettingsData()
    private val rightNow: Calendar = Calendar.getInstance()


    fun hourTemperatureList(): List<String> {
    val list = mutableListOf<String>()

    repeat(24)
    {
        val randomDecimal = Random.nextInt(20, 24)
        list.add(randomDecimal.toString())
    }
        return list
    }

    data class WeekTemperature(
        var maxTemperature: Int = 24,
        var minTemperature: Int = 20,
        var dayName: String = "Sat"
    )

    private fun getDayOfWeek(rep: Int): String {
        var dayName: String = "Today"
        if (rep==0){

        }
        else{
            val date: LocalDate = LocalDate.now().plusDays(rep.toLong())
            val dow: DayOfWeek = date.getDayOfWeek()
            dayName = dow.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)
        }

        return dayName
    }

    fun WeekTemperatureList(): List<WeekTemperature> {
        val weekTlist = mutableListOf<WeekTemperature>()
        var rep : Int = 0
        repeat(7)
        {
            val weekTemperature = WeekTemperature()
            weekTemperature.dayName = getDayOfWeek(rep)
            weekTlist.add(weekTemperature)
            rep += 1
        }
        return weekTlist
    }

    var currentTemperature: String = "+21"
        get() {
            return field
        }
        set(value) {
            field = value
        }

    var city: String = settingsData.city
        get() {
            return field
        }
        set(value) {
            field = value
        }

    val currentHOUR: Int
        get() {
            return rightNow.get(Calendar.HOUR_OF_DAY)
        }

    val currentDAY: Int
        get() {
            return rightNow.get(Calendar.HOUR_OF_DAY)
        }

    var statusShort: String = "Mostly Sunny"
        get() {
            return field
        }
        set(value) {
            field = value
        }

    var statusLong: String = "Sunny Condition will continue all day. Wind gusts are up to 7 mph."
        get() {
            return field
        }
        set(value) {
            field = value
        }



}