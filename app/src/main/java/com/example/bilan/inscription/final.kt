package com.example.myapplication_conditionphysique.NiveaauSport


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
//Ndeye Mour Ndiaye

class MyActivityfinal : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScreenContent()
        }
    }
}

@Composable
fun MyScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Ne vous inquiétez pas ! nous vous aiderons",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            color = Color.Black,
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        ) {
            ListItem("Analyse de vos données sanitaires et votre niveau sportif")
            ListItem("Elaboration d'un plan personnel pour vous")
            ListItem("Surveillance de vos progrès journaliers et construction de bonnes habitudes")
        }

        Button(
            onClick = { /* Do something */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
        ) {
            Text(text = "Je suis prêt !")
        }
    }
}

@Composable
fun ListItem(text: String) {
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "• ", color = Color.Black, style = MaterialTheme.typography.body1)
        Text(text = text, color = Color.Black, style = MaterialTheme.typography.body1)
    }
}
