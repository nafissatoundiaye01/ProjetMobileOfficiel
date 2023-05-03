package com.example.bilan.models


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val prenom: String,
    val nom: String,
    val sexe: String,
    val zone_cible: String,
    val objectifs: String,
    val poidsDebut: Double,
    val taille:Double,
    val poidsObjectif: Double,
    val poidsActuel: Double,
    val email: String,
    val password: String
)
