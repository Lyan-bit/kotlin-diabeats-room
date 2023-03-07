package com.example.diabeats

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diabeatsTable")
data class DiabeatsEntity (
    @PrimaryKey
    val id: String, 
    val pregnancies: Int, 
    val glucose: Int, 
    val bloodPressure: Int, 
    val skinThickness: Int, 
    val insulin: Int, 
    val bmi: Double, 
    val diabetesPedigreeFunction: Double, 
    val age: Int, 
    val outcome: String
)
