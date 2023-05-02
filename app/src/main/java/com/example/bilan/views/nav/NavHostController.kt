package com.example.bilan.views.nav

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.composable
import com.example.bilan.views.HomeScreen
import com.example.bilan.views.MyView
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class NavHostController() {
    companion object {
        @RequiresApi(Build.VERSION_CODES.M)
        @Composable
        fun createNavGraph(
            navController: androidx.navigation.NavHostController
        ) {
            NavHost(navController, startDestination = "/home") {
                composable("/home") {
                    HomeScreen()
                }
                composable("/myView") {
                    MyView()
                }
            }
        }
    }
}