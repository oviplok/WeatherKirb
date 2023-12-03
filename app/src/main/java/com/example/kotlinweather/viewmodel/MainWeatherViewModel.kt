import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinweather.data.repository.mockup.WeatherInfoMockup
import com.example.kotlinweather.data.repository.room.WeatherRepository
import com.example.kotlinweather.di.util.ServiceLocator
import com.example.kotlinweather.ui.state.WeatherUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

public class MainWeatherViewModel() :
    ViewModel(){
    private val repository =ServiceLocator.getInstance().repository
    var weatherUiState by mutableStateOf(WeatherUiState())
    private set
    private val weatherRepository: WeatherRepository




    init {
        weatherRepository = WeatherRepository(application = Application())
        checkDeadLine()
        fetchWeatherInfo()

    }

    private fun checkDeadLine(){

//        val currentTime = Timestamp(System.currentTimeMillis())
//        var current = SimpleDateFormat("EEEE", Locale.ENGLISH).format(currentTime * 1000)
//        var lastUpdate = weatherRepository.getLastUpdate()
        //lastUpdate=SimpleDateFormat("EEEE", Locale.ENGLISH).format(lastUpdate * 1000)
        //if()
    }

    private fun fetchWeatherInfo() {
        // Запросить информацию о погоде у репозитория
        viewModelScope.launch(Dispatchers.IO) {
            try {

                val dailyInfo = repository.getDailyWeatherInfo()
                val currentInfo = repository.getTodayWeatherInfo()
                val hourlyInfo = repository.getHourlyWeatherInfo()
                val newWeatherUiState: WeatherUiState = WeatherUiState(
                    city = currentInfo.value?.city.toString(),
                    temperature = currentInfo.value?.currentTemperature.toString(),
                    shortStatus = currentInfo.value?.descriptionShort.toString(),
                    longStatus = currentInfo.value?.descriptionLong.toString(),
                    currentDay = WeatherInfoMockup().currentDAY,
                    currentHour = WeatherInfoMockup().currentHOUR,
//                    hourTList = weatherInfo.hourTemperatureList(),
//                    weekTList = weatherInfo.weekTemperatureList()
                    )

                viewModelScope.launch {
                    weatherUiState = newWeatherUiState
                }

                Log.i("uiStatus_ViewModel: ", currentInfo.value?.city.toString() )

            } catch (e: Exception) {
                Log.e("uiStatus_ViewModel: ","ERROR in ViewModel: ",e)
            }
        }
    }
}
