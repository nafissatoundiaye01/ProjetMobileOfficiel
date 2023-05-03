package com.example.myfitnessapp.model

import androidx.compose.runtime.Composable
import com.example.myfitnessapp.controller.ExerciseController
import com.example.myfitnessapp.view.ExerciseListView

class ExerciseModel {
    private val controller = ExerciseController()

    fun getExercises(): List<Exercise> {
        return controller.getExercises()
    }

    @Composable
    fun ExerciseList() {
        val exercises = getExercises()
        ExerciseListView(exercises = exercises)
    }
}