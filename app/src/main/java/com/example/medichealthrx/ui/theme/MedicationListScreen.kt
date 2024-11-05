package com.example.medichealthrx.ui.theme



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.medichealthrx.model.Medication
import com.example.medichealthrx.viewmodel.MedicationViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicationListScreen(viewModel: MedicationViewModel) {
    val medications by viewModel.allMedications.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text("Medication Reminder") }
            )
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.fillMaxSize()
        ) {
            items(medications.size) { index ->
                val medication = medications[index]
                MedicationItem(medication)
            }
        }
    }
}

@Composable
fun MedicationItem(medication: Medication) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Name: ${medication.name}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Dosage: ${medication.dosage}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Frequency: ${medication.frequency}", style = MaterialTheme.typography.bodyMedium)
    }
}
