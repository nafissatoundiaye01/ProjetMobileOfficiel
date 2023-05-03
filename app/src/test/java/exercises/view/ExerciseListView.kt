package com.example.myfitnessapp.view


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myfitnessapp.model.Exercise


@Composable
fun ExerciseListView(exercises: List<Exercise>) {
    LazyColumn {
        items(exercises) { exercise ->
            ExerciseItem(exercise = exercise)
        }
    }
}
@Composable
fun ExerciseItem(exercise: Exercise) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {

        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxWidth()
        ) {
            Text(text = exercise.name, fontWeight = FontWeight.Bold)
            Text(text = exercise.description, color = Color.Gray, maxLines = 2)
            Text(text = "Difficulty: ${exercise.difficulty}", color = Color.Gray)
        }
    }
}
