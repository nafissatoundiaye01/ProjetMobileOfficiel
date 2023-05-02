package com.example.bilan

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavigatorProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bilan.database.FitnessDatabase
import com.example.bilan.models.User
import com.example.bilan.repositories.UserRepository
import com.example.bilan.ui.theme.BilanTheme
import com.example.bilan.viewmodels.AjoutViewModel
import com.example.bilan.viewmodels.BilanViewModel
import com.example.bilan.viewmodels.Graph
import com.example.bilan.viewmodels.UserViewModel
import com.example.bilan.views.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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



           MyView()
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