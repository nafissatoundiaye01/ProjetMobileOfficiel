package com.example.bilan.maintenance

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bilan.models.Entrainements
import com.example.bilan.models.UserSession
import com.example.bilan.viewmodels.BilanViewModel
import com.example.bilan.viewmodels.Graph.entrainementsRepo
import java.time.DayOfWeek
import java.time.LocalDate

class MiseAJourEntrainements() {


    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun createWeeklyWorkoutsIfMonday() {
        val viewModel = viewModel(BilanViewModel::class.java)
        val state by viewModel.state.collectAsState()
        val session = UserSession()
        val user = session.getSession()
        val today = LocalDate.now()
        if (today.dayOfWeek == DayOfWeek.MONDAY && state.entrainementsAllDayWeek[1]==null) {
            for (i in 0..6) {
                val date = today.plusDays(i.toLong())
                val entrainement = Entrainements(
                    nom = "Entraînement du jour $date",
                    duree = 0,
                    calories = 0.0,
                    userId = user.id,
                    date = date
                )

                LaunchedEffect(date) {
                    entrainementsRepo.insertEntrainements(entrainement)
                }

            }
        }
    }

}