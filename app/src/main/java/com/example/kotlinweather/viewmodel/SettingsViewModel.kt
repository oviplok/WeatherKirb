package com.example.kotlinweather.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinweather.repository.WeatherRepository
import com.example.kotlinweather.ui.state.SettingsUiState
import kotlinx.coroutines.launch

public class SettingsViewModel(): ViewModel() {

    var settingsUiState by mutableStateOf(SettingsUiState())
        private set
    private val weatherRepository: WeatherRepository = WeatherRepository()


    init {
        // Загрузка данных о погоде при создании ViewModel
        fetchSettings()
    }

    private fun fetchSettings(){
        viewModelScope.launch {
            try {
            val settingsInfo = weatherRepository.getSettings()
            val newSettingsUiState: SettingsUiState = SettingsUiState(
                city = settingsInfo.city)

            viewModelScope.launch {
                settingsUiState = newSettingsUiState
            }
        } catch (e: Exception) {
            Log.e("uiStatus_ViewModel: ","ERROR in ViewModel: ",e)
        }}
    }
}