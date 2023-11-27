import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinweather.repository.room.WeatherRepository
import com.example.kotlinweather.ui.state.WeatherUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale

public class MainWeatherViewModel() :
    ViewModel(){

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

                val weatherInfo = weatherRepository.getMockupWeatherInfo()
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
