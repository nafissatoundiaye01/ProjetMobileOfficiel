package com.example.bilan.viewmodels

import android.content.Context
import com.example.bilan.database.FitnessDatabase
import com.example.bilan.models.Entrainements
import com.example.bilan.repositories.EntrainementsRepository
import com.example.bilan.repositories.UserRepository


object Graph {
    lateinit var database: FitnessDatabase
        private set
    val userRepo by lazy {
        UserRepository(database.userDao())
    }

    val entrainementsRepo by lazy {
        EntrainementsRepository(database.entrainementsDao())
    }

    fun provide(context: Context) {
        database = FitnessDatabase.getDatabase(context)
    }
}