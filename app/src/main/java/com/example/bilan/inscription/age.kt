package com.example.bilan.info


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Ndeye Mour Ndiaye


class MonAgeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { 
            //MyScreen3()
        }
    }
}

@Composable
fun MonAgeScreen(onTaille:()->Unit) {
    Surface(color = MaterialTheme.colors.background){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Title
        Text(
            text = "Quel est votre âge ?",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        // Subtitle
        Text(
            text = "Cela nous aidera à ajuster l'entraînement qui convient le mieux à votre tranche d'âge",
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(16.dp)
        )

        // Input field
        val ageState = remember { mutableStateOf("") }
        TextField(
            value = ageState.value,
            onValueChange = { ageState.value = it },
            modifier = Modifier.padding(16.dp)
        )

        // Button
        Button(
            onClick = {
                onTaille()
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Suivant")
        }
    }
}
}

@Preview
@Composable
fun MonAgeScreenPreview() {
   // MonAgeScreen()
}
