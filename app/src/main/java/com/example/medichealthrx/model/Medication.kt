package com.example.medichealthrx.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Medication(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val dosage: String,
    val frequency: String,
    val startDate: Long,
    val endDate: Long
)
