package com.example.kotlinweather.di.util

import android.app.Application
import com.example.kotlinweather.data.repository.RepositoryActions
import com.example.kotlinweather.data.repository.mockup.MockRepository
import com.example.kotlinweather.data.repository.room.WeatherRepository

class ServiceLocator {
    private lateinit var context: Application

    //private val api: RepositoryActions = APIRepository()
    private val mock: RepositoryActions = MockRepository()
    private var room: RepositoryActions? = null


    companion object{
        @Volatile
        private var instance: ServiceLocator?=null

        fun getInstance() = instance ?: synchronized(this){
            instance ?: ServiceLocator().also{ instance =it}
        }
    }

    fun init(app: Application){
        context=app
        room = WeatherRepository(app)
    }

    val repository: RepositoryActions
        get() {
//            if(isInternetAvailable(context)) return api
            return room ?: mock
        }

}