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


class MyTPActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //MyTPScreen()
        }
    }
}


@Composable
fun MyTPScreen(onTemps:()->Unit) {
    Surface(color = MaterialTheme.colors.background) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Text field for height
        Text(
            text = "Quelle est votre taille (cm) ?",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        // Input field for height
        val heightState = remember { mutableStateOf("") }
        TextField(
            value = heightState.value,
            onValueChange = { heightState.value = it },
            modifier = Modifier.padding(16.dp)
        )

        // Text field for weight
        Text(
            text = "Quelle est votre masse (kg) ?",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        // Input field for weight
        val weightState = remember { mutableStateOf("") }
        TextField(
            value = weightState.value,
            onValueChange = { weightState.value = it },
            modifier = Modifier.padding(16.dp)
        )
        // Text field for height
        Text(
            text = "Quelle est votre masse ideal(kg) ?",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        // Input field for height
        remember { mutableStateOf("") }
        TextField(
            value = heightState.value,
            onValueChange = { heightState.value = it },
            modifier = Modifier.padding(16.dp)
        )

        // Next button
        Button(
            onClick = {
                onTemps()
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
fun MyTPPreview() {
   // MyTPScreen()
}
