package com.example.bilan.info


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person

//Ndeye Mour Ndiaye


class MyTimeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //MyTimeScreen()
        }
    }
}

@Composable
fun MyTimeScreen(onNivSport:()->Unit) {
    Surface(color = MaterialTheme.colors.background) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Text field for goal weight
        Text(
            text = "D'ici combien de temps souhaité vous atteindre votre poids idéal ?",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        // Date picker
        val selectedDate = remember { mutableStateOf("") }
        OutlinedTextField(
            value = selectedDate.value,
            onValueChange = { selectedDate.value = it },
            placeholder = { Text(text = "Choisissez une date") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            leadingIcon = { Icon(Icons.Filled.DateRange, "") }
        )

        // Button
        Button(
            onClick = {
               onNivSport()
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
fun MyTimeScreenPreview() {
    //MyTimeScreen()
}

