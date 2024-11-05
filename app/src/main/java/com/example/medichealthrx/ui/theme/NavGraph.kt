package com.example.medichealthrx.ui.theme



import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.medichealthrx.viewmodel.MedicationViewModel


@Composable
fun NavGraph(navController: NavHostController, viewModel: MedicationViewModel) {
    NavHost(navController = navController, startDestination = "medication_list") {
        composable("medication_list") {
            MedicationListScreen(viewModel = viewModel)
        }
        composable("add_medication") {
            AddMedicationScreen(viewModel = viewModel)
        }
    }
}
