package com.example.myfitnessapp.model

import android.media.Image
import android.widget.ImageView
import androidx.compose.runtime.Composable
import com.example.myfitnessapp.controller.ExerciseController


data class Exercise(
    val name: String,
    val description: String,
    val image: Int,
    val difficulty: String
)


