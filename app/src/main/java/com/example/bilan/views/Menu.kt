package com.example.bilan.views

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun BottomNavigationBar() {
    BottomNavigation(
        backgroundColor = Color.DarkGray
    ) {
        BottomNavigationItem(

            selected = true,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "exercices",
                    tint = Color.LightGray
                )
            },
            label = { Text("Exercices",color=Color.LightGray) }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "bilan",
                    tint = Color.LightGray
                )
            },
            label = { Text("Bilan",color= Color.LightGray) }
        )
        BottomNavigationItem(
            selected = false,
            onClick = {  },
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Profil",
                    tint =  Color.LightGray
                )
            },
            label = { Text("Profil",color=Color.LightGray) }
        )
    }
}
