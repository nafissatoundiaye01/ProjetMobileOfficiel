package com.example.bilan.models


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entrainements")
data class Entrainements(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nom: String,
    val duree: Int,
    val calories: Int,
    val userId: Int
)
