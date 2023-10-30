import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinweather.repository.WeatherRepository
import com.example.kotlinweather.repository.model.WeatherInfoMockup
import com.example.kotlinweather.repository.model.weatherapimodel.Weather
import com.example.kotlinweather.ui.state.WeatherUiState
import com.example.kotlinweather.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

public class MainWeatherViewModel() :
    ViewModel(){

    var weatherUiState by mutableStateOf(WeatherUiState())
    private set
    private val weatherRepository: WeatherRepository = WeatherRepository()

    init {
        fetchWeatherInfo()
    }

    private fun fetchWeatherInfo() {
        // Запросить информацию о погоде у репозитория
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val weatherInfo = weatherRepository.getWeatherInfo()
                val newWeatherUiState: WeatherUiState = WeatherUiState(city = weatherInfo.city,
                    temperature = weatherInfo.currentTemperature,
                    shortStatus = weatherInfo.statusShort,
                    longStatus = weatherInfo.statusLong,
                    currentDay = weatherInfo.currentDAY,
                    currentHour = weatherInfo.currentHOUR,
                    hourTList = weatherInfo.hourTemperatureList(),
                    weekTList = weatherInfo.WeekTemperatureList()
                    )

                viewModelScope.launch {
                    weatherUiState = newWeatherUiState
                }

                Log.i("uiStatus_ViewModel: ",weatherInfo.statusShort )

            } catch (e: Exception) {
                Log.e("uiStatus_ViewModel: ","ERROR in ViewModel: ",e)
            }
        }
    }
}
