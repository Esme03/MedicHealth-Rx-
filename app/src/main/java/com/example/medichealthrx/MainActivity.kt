package com.example.medichealthrx

import com.example.medichealthrx.model.MedicationDatabase
import com.example.medichealthrx.repository.MedicationRepository
import com.example.medichealthrx.ui.theme.MedicHealthRxTheme
import com.example.medichealthrx.viewmodel.MedicationViewModel
import com.example.medichealthrx.viewmodel.MedicationViewModelFactory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.medichealthrx.ui.theme.NavGraph


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar la base de datos y el repositorio
        val dao = MedicationDatabase.getDatabase(applicationContext).medicationDao()
        val repository = MedicationRepository(dao)
        val viewModelFactory = MedicationViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory)[MedicationViewModel::class.java]

        setContent {
            MedicHealthRxTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController, viewModel = viewModel)
            }
        }
    }
}
