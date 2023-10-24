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
    // LiveData для отображения информации о погоде
    // val weatherUiState: WeatherUiState = WeatherUiState()
    //    val city: MutableLiveData<String> = MutableLiveData()
    //    val temperature: MutableLiveData<String> = MutableLiveData()
    //    val shortStatus: MutableLiveData<String> = MutableLiveData()
    //    val longStatus: MutableLiveData<String> = MutableLiveData()
    //    val currentHour: MutableLiveData<Int> = MutableLiveData()
    //    val currentDay: MutableLiveData<Int> = MutableLiveData()
    //    val hourTList: MutableLiveData<List<String>> = MutableLiveData()
    //    val weekTList: MutableLiveData<List<WeatherInfoMockup.WeekTemperature>> = MutableLiveData()
    private val weatherRepository: WeatherRepository = WeatherRepository()

    // TODO: Не инициализирует VM 
    init {

        // Загрузка данных о погоде при создании ViewModel
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
                weatherUiState = newWeatherUiState;

                Log.i("uiStatus_ViewModel: ",weatherInfo.statusShort )


//                city.value
//                // Обновить LiveData с новыми значениями
//                city.postValue(weatherInfo.city.toString())
//                temperature.postValue(weatherInfo.currentTemperature)
//                shortStatus.postValue(weatherInfo.statusShort)
//                longStatus.postValue(weatherInfo.statusLong)
//                currentHour.postValue(weatherInfo.currentHOUR)
//                currentDay.postValue(weatherInfo.currentDAY)
//                hourTList.postValue(weatherInfo.hourTemperatureList())
//                weekTList.postValue(weatherInfo.WeekTemperatureList())
            } catch (e: Exception) {
                //return@launch Resource.Error("An unknown error occured:(")
            }
        }
    }
}
