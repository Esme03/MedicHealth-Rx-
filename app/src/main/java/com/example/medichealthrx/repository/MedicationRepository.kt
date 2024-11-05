package com.example.medichealthrx.repository


import androidx.lifecycle.LiveData
import com.example.medichealthrx.model.Medication
import com.example.medichealthrx.model.MedicationDao

import kotlinx.coroutines.flow.Flow

class MedicationRepository(private val medicationDao: MedicationDao) {

    // Obtener todos los medicamentos
    fun getAllMedications(): LiveData<List<Medication>> {
        return medicationDao.getAllMedications()
    }

    // Insertar un nuevo medicamento
    suspend fun insertMedication(medication: Medication) {
        medicationDao.insert(medication)
    }

    // Eliminar un medicamento
    suspend fun deleteMedication(medication: Medication) {
        medicationDao.delete(medication)
    }

}
