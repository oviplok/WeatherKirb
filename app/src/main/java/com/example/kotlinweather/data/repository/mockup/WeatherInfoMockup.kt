package com.example.kotlinweather.data.repository.mockup

import com.example.kotlinweather.data.model.DailyWeatherData
import com.example.kotlinweather.data.model.HourlyWeatherData
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Calendar
import java.util.Locale
import kotlin.random.Random

class WeatherInfoMockup {
    private var settingsData = SettingsInfoMockup()
    private val rightNow: Calendar = Calendar.getInstance()


    fun hourTemperatureList(): List<HourlyWeatherData> {
        val list = mutableListOf<HourlyWeatherData>()
        var rep : Int = 0
        repeat(24)
        {
              val hourTemperature = HourlyWeatherData(
                  time = currentHOUR+rep,
                  city=city,
                  minTemperature = 20,
                  maxTemperature = 24,
                  icon = "default"
              )
            rep+=1
    //        val randomDecimal = Random.nextInt(20, 24)
    //        list.add(randomDecimal.toString())
        }
            return list
    }

    fun weekTemperatureList(): List<DailyWeatherData> {
        val weekTlist = mutableListOf<DailyWeatherData>()
        var rep : Int = 0
        repeat(7)
        {
            val weekTemperature = DailyWeatherData(
                dayName = getDayOfWeek(rep),
                city=city,
                minTemperature = WeekTemperature().minTemperature,
                maxTemperature = WeekTemperature().maxTemperature,
                icon = "default")
//            weekTemperature.dayName = getDayOfWeek(rep)
            weekTlist.add(weekTemperature)
            rep += 1
        }
        return weekTlist
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

    var currentTemperature: String = "+21"

    var city: String = settingsData.city

    var currentHOUR: Int = rightNow.get(Calendar.HOUR_OF_DAY)

    var currentDAY: Int = rightNow.get(Calendar.HOUR_OF_DAY)

    var statusShort: String = "Mostly Sunny"

    var statusLong: String = "Sunny Condition will continue all day. Wind gusts are up to 7 mph."


}