package com.example.myfitnessapp.controller

import android.widget.ImageView
import com.example.myfitnessapp.R
import com.example.myfitnessapp.model.Exercise

class ExerciseController {
    private val exercises = listOf(
        Exercise("Squats", "Squats are a great way to tone your legs and glutes.", R.drawable.squat , "Beginner"),
        Exercise("Push-ups", "Push-ups are a classic exercise for building upper body strength.", R.drawable.pushup, "Intermediate"),
        Exercise("Crunches", "Crunches are a popular exercise for toning your abs.", R.drawable.crunches, "Beginner"),
        Exercise("Planks", "Planks are a great exercise for building core strength.", R.drawable.plank, "Intermediate"),
        Exercise("Lunges", "Lunges are a great way to work your legs and glutes.", R.drawable.lunges, "Intermediate"),
        Exercise("Burpees", "Burpees are a full-body exercise that can help you burn calories and improve cardiovascular fitness.", R.drawable.burpees, "Advanced")
    )

    fun getExercises(): List<Exercise> {
        return exercises
    }
}