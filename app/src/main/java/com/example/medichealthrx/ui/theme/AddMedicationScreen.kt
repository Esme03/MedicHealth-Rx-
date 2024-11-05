package com.example.medichealthrx.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.medichealthrx.model.Medication
import com.example.medichealthrx.viewmodel.MedicationViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMedicationScreen(viewModel: MedicationViewModel) {
    val name = remember { mutableStateOf("") }
    val dosage = remember { mutableStateOf("") }
    val frequency = remember { mutableStateOf("") }

    // Usa SnackbarHostState en lugar de ScaffoldState
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Medication") }
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }, // Configura SnackbarHost aquí
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                TextField(
                    value = name.value,
                    onValueChange = { name.value = it },
                    label = { Text("Medication Name") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = dosage.value,
                    onValueChange = { dosage.value = it },
                    label = { Text("Dosage") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = frequency.value,
                    onValueChange = { frequency.value = it },
                    label = { Text("Frequency") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        if (name.value.isNotBlank() && dosage.value.isNotBlank() && frequency.value.isNotBlank()) {
                            val medication = Medication(
                                name = name.value,
                                dosage = dosage.value,
                                frequency = frequency.value,
                                startDate = System.currentTimeMillis(),
                                endDate = System.currentTimeMillis() + 10000000 // Ejemplo de duración
                            )
                            viewModel.insertMedication(medication)

                            scope.launch {
                                snackbarHostState.showSnackbar("Medication added successfully") // Muestra el snackbar aquí
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Add Medication")
                }
            }
        }
    )
}
