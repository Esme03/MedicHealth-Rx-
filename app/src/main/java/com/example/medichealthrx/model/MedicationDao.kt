package com.example.medichealthrx.model


import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MedicationDao {
    @Query("SELECT * FROM Medication")
    fun getAllMedications(): LiveData<List<Medication>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(medication: Medication)

    @Delete
    suspend fun delete(medication: Medication)
}
