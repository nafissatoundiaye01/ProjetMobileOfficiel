package com.example.myapplication_conditionphysique


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bilan.objectifs.*
import com.example.bilan.HomePage
import com.example.bilan.info.*
import com.example.myapplication_conditionphysique.NiveaauSport.*


//Ndeye Mour Ndiaye

sealed class NavRoute(val route: String) {
    object HomePage : NavRoute("HomePage")
    object  Presentation1Screen: NavRoute("Presentation1Screen")
    object  GenderScreen: NavRoute("GenderScreen")
    object  MyScreen: NavRoute("MyScreen")

}

@Composable
fun NavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoute.HomePage.route,
    ) {
        //ROUTE HOME
        composable(NavRoute.HomePage.route) {
            HomePage(

                onPresentation = {
                    navController.navigate(NavRoute.Presentation1Screen.route)
                }
            )
        }

        composable(NavRoute.Presentation1Screen.route) {
            Presentation1Screen(
                Presentation = {
                    navController.navigate("PresentationScreen")
                }
            )
        }

        composable("PresentationScreen") {
            PresentationScreen(
                onGenre = {
                    navController.navigate(NavRoute.GenderScreen.route)
                }
            )
        }
        composable("GenderScreen") {
            GenderScreen(
                onOption = {
                     navController.navigate(NavRoute.MyScreen.route)
                }

            )
        }/*
        composable(NavRoute.MyScreen.route+"/id") {
            MyScreen(
                onValidation = {
                    navController.navigate("ObjectiveSelectionScreen")
                },
                user:User
            )
        }*/
        composable("ObjectiveSelectionScreen"){
            GoalSelectionScreen (
                onGoalsSelected = {
                    navController.navigate("Presentation2Screen")

                }
                    )


        }
        composable("Presentation2Screen"){
            Presentation2Screen(
                onPresentation = {
                    navController.navigate("MyScreen2")
                }
            )
        }
        composable("MyScreen2"){
            MyScreen2(
                onAge = {
                    navController.navigate("MonAgeScreen")
                }
            )
        }
        composable("MonAgeScreen"){
            MonAgeScreen(
                onTaille = {
                    navController.navigate("MyTPScreen")
                }


            )
        }
        composable("MyTPScreen"){
            MyTPScreen(
                onTemps = {
                    navController.navigate("MyTimeScreen")
                }
            )
        }
        composable("MyTimeScreen"){
            MyTimeScreen(
            onNivSport ={
                navController.navigate("Presentation22Screen")
            })
        }
      composable("Presentation22Screen"){
          Presentation22Screen(
              onNivAct = {
                  navController.navigate("MyScreen33")
              }

          )
      }
        composable("MyScreen33"){
            MyScreen33(
                onEqui = {
                navController.navigate("MyEquipementScreen")

            }
            )
        }
        composable("MyEquipementScreen"){
            MyEquipementScreen(
                onConnexion ={ navController.navigate("LoginView")
                }
            )
        }
        composable("LoginView"){
            LoginView(
                onfinal = {
                    navController.navigate("MyScreenContent")
                }
            )
        }
composable("MyScreenContent"){
    MyScreenContent()
}
    }
    }
