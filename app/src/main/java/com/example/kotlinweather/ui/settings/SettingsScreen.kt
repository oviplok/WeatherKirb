package com.example.kotlinweather.ui.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinweather.R

@Preview
@Composable
fun Settings(){
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
                .padding(top = 20.dp))
    }
}