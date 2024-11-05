package com.example.medichealthrx.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.medichealthrx.repository.MedicationRepository


class MedicationViewModelFactory(private val repository: MedicationRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MedicationViewModel::class.java)) {
            return MedicationViewModel(repository,) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
