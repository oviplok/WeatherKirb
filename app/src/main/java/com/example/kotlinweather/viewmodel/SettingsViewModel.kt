package com.example.kotlinweather.viewmodel

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinweather.data.repository.room.WeatherRepository
import com.example.kotlinweather.di.util.ServiceLocator
import com.example.kotlinweather.ui.state.SettingsUiState
import kotlinx.coroutines.launch

public class SettingsViewModel(): ViewModel() {

    private val repository = ServiceLocator.getInstance().repository
    var settingsUiState by mutableStateOf(SettingsUiState())
        private set
    private val weatherRepository: WeatherRepository


    init {
        weatherRepository = WeatherRepository(application = Application())
        // Загрузка данных о погоде при создании ViewModel
        fetchSettings()
    }

    private fun fetchSettings(){
        viewModelScope.launch {
            try {
                val settingsInfo= repository.getSettings()
//            val settingsInfo = weatherRepository.getMockupSettings()
                val newSettingsUiState: SettingsUiState = SettingsUiState(
                    city = settingsInfo.value?.city.toString())
                viewModelScope.launch {
                    settingsUiState = newSettingsUiState
                }
            } catch (e: Exception) {
                Log.e("uiStatus_ViewModel: ","ERROR in ViewModel: ",e)
            }
        }
    }
}