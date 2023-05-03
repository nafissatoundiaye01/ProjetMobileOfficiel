package com.bilan.objectifs


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//Ndeye Mour Ndiaye



class MainActivity : ComponentActivity() {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


                setContent {

        }
    }
}
enum class Goal(val label: String, val icon: Int) {
    MUSCULATION("Musculation", com.example.bilan.R.drawable.musculation),
    REMISE_EN_FORME("Remise en forme", com.example.bilan.R.drawable.remise_en_forme),
    PERTE_DE_POIDS("Perte de poids", com.example.bilan.R.drawable.perte_de_poids)
}

@Composable
fun GoalSelectionScreen( onGoalsSelected: (selectedGoal: Goal) -> Unit) {
    var selectedGoal by remember { mutableStateOf<Goal?>(null) }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Sélectionnez votre objectif sportif",
            style = MaterialTheme.typography.h5
        )

        Spacer(modifier = Modifier.height(16.dp))

        Goal.values().forEach { goal ->
            GoalOption(
                goal = goal,
                isSelected = selectedGoal == goal,
                onSelected = { selectedGoal = goal }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            enabled = selectedGoal != null,
            onClick = { selectedGoal?.let(onGoalsSelected) }
        ) {
            Text(text = "Suivant")
        }
    }
}

@Composable
fun GoalOption(goal: Goal, isSelected: Boolean, onSelected: () -> Unit) {
    val backgroundColor = if (isSelected)  Color(0xFFFF4081) else Color.White
    val borderColor = if (isSelected) Color(0xFFFF4081) else Color.White

    Column(
        modifier = Modifier
            .padding(16.dp)
            .clickable(onClick = onSelected)
    ) {
        Image(
            painter = painterResource(goal.icon),
            contentDescription = goal.label,
            modifier = Modifier
                .size(120.dp)
                .background(backgroundColor, CircleShape)
                .border(
                    BorderStroke(4.dp, borderColor),
                    CircleShape
                ),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = goal.label,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GoalSelectionScreen(onGoalsSelected = {})
}
