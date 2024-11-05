package com.example.medichealthrx.viewmodel

import androidx.lifecycle.LiveData
import com.example.medichealthrx.model.Medication
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medichealthrx.repository.MedicationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MedicationViewModel(private val repository: MedicationRepository, val it: List<Medication>) : ViewModel() {

    // Flujo de datos reactivos para almacenar la lista de medicamentos
    private val _allMedications = MutableStateFlow<List<Medication>>(emptyList())
    val allMedications: StateFlow<List<Medication>> = _allMedications

    init {
        // Cargar medicamentos al inicializar el ViewModel
        getMedications()
    }

    private fun getMedications() {
        viewModelScope.launch {
            // Aquí recogemos los medicamentos usando collect del Flow
            repository.getAllMedications().collect {
                _allMedications.value = it
            }
        }
    }

    // Función para insertar un medicamento en la base de datos
    fun insertMedication(medication: Medication) {
        viewModelScope.launch {
            repository.insertMedication(medication)
        }
    }

    // Función para eliminar un medicamento de la base de datos
    fun deleteMedication(medication: Medication) {
        viewModelScope.launch {
            repository.deleteMedication(medication)
        }
    }
}

private fun <T> LiveData<T>.collect(any: Any) {
    TODO("Not yet implemented")
}

