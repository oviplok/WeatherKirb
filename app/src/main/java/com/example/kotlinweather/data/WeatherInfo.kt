package com.example.kotlinweather.data

import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import java.util.Calendar
import kotlin.random.Random

class WeatherInfo() {

    val rightNow = Calendar.getInstance()


    fun hourTempList(): MutableList<String> {
    val list = mutableListOf<String>()

    repeat(24)
    {
        val randomDecimal = Random.nextInt(20, 24)
        list.add(randomDecimal.toString())
    }
        return list
}


    val currentHOUR: Int
        get() {
            return rightNow.get(Calendar.HOUR_OF_DAY)
        }

    val currentDAY: Int
        get() {
            return rightNow.get(Calendar.HOUR_OF_DAY)
        }

    var StatusShort: String = ""
        get() {
            return field
        }
        set(value) {
            field = value
        }

    var StatusLong: String = ""
        get() {
            return field
        }
        set(value) {
            field = value
        }



}