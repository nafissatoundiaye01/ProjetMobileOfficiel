package com.example.myapplication_conditionphysique.NiveaauSport


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Ndeye Mour Ndiaye


class MyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //MyScreen33()
        }
    }
}

enum class SportLevel(val label: String) {
    NO_SPORT("Aucun sport"),
    WALKING("souvent de la marche"),
    SPORT("Souvent du sport"),
    VERY_SPORT(" Très sportive")
}

@Composable
fun MyScreen33(onEqui:()->Unit) {
    var selectedOption by remember { mutableStateOf(SportLevel.NO_SPORT) }
    val scale by animateFloatAsState(if (selectedOption == SportLevel.NO_SPORT) 1.5f else 1f)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Text field for sport level
        Text(
            text = "Quel est votre niveau sportif ?",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        // Options for sport level
        for (level in SportLevel.values()) {
            Text(
                text = level.label,
                color = if (selectedOption == level) Color.Magenta else Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(8.dp)
                    .scale(scale)
                    .clickable { selectedOption = level }
            )
        }

        // Button
        Button(
            onClick = {
                onEqui()
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Suivant")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
   // MyScreen()
}
