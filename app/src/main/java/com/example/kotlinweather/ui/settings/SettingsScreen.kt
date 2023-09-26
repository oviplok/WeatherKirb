package com.example.kotlinweather.ui.settings

import android.content.Context
import android.preference.CheckBoxPreference
import android.preference.PreferenceScreen
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.preferencesDataStore
import com.example.kotlinweather.R
import com.jamal.composeprefs3.ui.prefs.CheckBoxPref
import java.util.prefs.Preferences



//val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Settings(){

    var cityCurrent by rememberSaveable { mutableStateOf("Moscow") }
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
