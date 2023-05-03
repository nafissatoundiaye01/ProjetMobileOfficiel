package com.example.bilan.models


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "entrainements")
data class Entrainements(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nom: String,
    val duree: Int,
    var calories: Double,
    val userId: Int,
    val date: LocalDate
)
