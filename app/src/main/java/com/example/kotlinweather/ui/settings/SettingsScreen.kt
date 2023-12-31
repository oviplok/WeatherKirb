package com.example.kotlinweather.ui.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlinweather.R
import com.example.kotlinweather.repository.model.SettingsData
import com.example.kotlinweather.ui.state.SettingsUiState
import com.example.kotlinweather.ui.state.WeatherUiState
import com.example.kotlinweather.viewmodel.SettingsViewModel


//val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Settings(viewModel: SettingsViewModel = viewModel()){
    val uiState: SettingsUiState = viewModel.settingsUiState

    //var settingsData = SettingsData()
    var cityCurrent by rememberSaveable { mutableStateOf(uiState.city) }
    val cityCheckedState = remember { mutableStateOf(true) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .paint(
            painterResource(id = R.drawable.back_cloudy),
            contentScale = ContentScale.FillHeight
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Settings",
            color = Color.White,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 20.dp)
                //.padding(horizontal = 20.dp)
        )
            TextField(
                modifier = Modifier
                    .padding(top = 20.dp),
                shape = RoundedCornerShape(10.dp),
                value = cityCurrent,
                onValueChange = {
                    cityCurrent = it
                },
                label = {
                    Text("Your city"
                )},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )


//        CheckBoxPref(
//            key = "cb1",
//            title = "Simple checkbox",
//            summary = "But with a leading icon and summary",
//            leadingIcon = { Icon(Icons.Filled.Person, "Person") }
//        )
    }


}
