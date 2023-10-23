package com.example.kotlinweather.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.kotlinweather.repository.model.SettingsData

class SettingsViewModel(
    private val repository: SettingsData
): ViewModel() {

}