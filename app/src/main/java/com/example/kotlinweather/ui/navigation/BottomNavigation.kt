package com.example.kotlinweather.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.Colors


@Composable
fun BottomNavigation(navController: NavHostController) {
    val listItems = listOf(
        BottomItem.MainWeatherScreen,
        BottomItem.SettingsScreen
    )

    NavigationBar(
        modifier = Modifier.background(Color(0xFF00A6FF)
        )
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        listItems.forEach{ item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = { navController.navigate(item.route) },
                icon = { Icon(painter = painterResource(id = item.iconId), contentDescription ="Icon" )},
                label = { Text(text = item.title, fontSize = 9.sp)},
            )
        }
    }
}

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(bottomBar =
    {
        BottomNavigation(navController = navController)
    })
    { paddingValues ->
        Column(
            modifier = Modifier
//                .fillMaxSize()
                .padding(bottom = paddingValues.calculateBottomPadding())
//                .verticalScroll(rememberScrollState())
        ) {
            NavGraph(navHostController = navController)
        }
    }
}

//@Composable
//fun BottomNavigation(navController: NavHostController) {
//
//}

