package com.example.bilan

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import androidx.navigation.NavigatorProvider
import com.example.bilan.ui.theme.BilanTheme
import com.example.bilan.viewmodels.Graph
import com.example.bilan.views.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("CoroutineCreationDuringComposition")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navigatorProvider = NavigatorProvider()

        setContent {
            /*val navController= rememberNavController()
            NavHost(navController, startDestination = "/home") {
                composable("/home") {
                    HomeScreen(navController)
                }
                composable("/myView") {
                    MyView()
                }
            }*/
            Graph.provide(this)



        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BilanTheme {
        Greeting("Android")
    }
}