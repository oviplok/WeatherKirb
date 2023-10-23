import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinweather.repository.WeatherRepository
import com.example.kotlinweather.repository.model.WeatherInfoMockup
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainWeatherViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {
    // LiveData для отображения информации о погоде
    val city: MutableLiveData<String> = MutableLiveData()
    val temperature: MutableLiveData<String> = MutableLiveData()
    val shortStatus: MutableLiveData<String> = MutableLiveData()
    val longStatus: MutableLiveData<String> = MutableLiveData()
    val currentHour: MutableLiveData<Int> = MutableLiveData()
    val currentDay: MutableLiveData<Int> = MutableLiveData()
    val hourTList: MutableLiveData<List<String>> = MutableLiveData()
    val weekTList: MutableLiveData<List<WeatherInfoMockup.WeekTemperature>> = MutableLiveData()

    init {
        // Загрузка данных о погоде при создании ViewModel
        fetchWeatherInfo()
    }

    private fun fetchWeatherInfo() {
        // Запросить информацию о погоде у репозитория
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val weatherInfo = weatherRepository.getWeatherInfo()
                city.value
                // Обновить LiveData с новыми значениями
                city.postValue(weatherInfo.city.toString())
                temperature.postValue(weatherInfo.currentTemperature)
                shortStatus.postValue(weatherInfo.statusShort)
                longStatus.postValue(weatherInfo.statusLong)
                currentHour.postValue(weatherInfo.currentHOUR)
                currentDay.postValue(weatherInfo.currentDAY)
                hourTList.postValue(weatherInfo.hourTemperatureList())
                weekTList.postValue(weatherInfo.WeekTemperatureList())
            } catch (e: Exception) {

            }
        }
    }
}
