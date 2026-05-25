package com.example.kibu.ui.screens.savings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kibu.ui.theme.*

@Composable
fun NewPocketScreen(
    onBack: () -> Unit,
    onPocketCreated: (SavingPocket) -> Unit
) {
    var name by remember { mutableStateOf("Vacaciones") }
    var goalText by remember { mutableStateOf("1500000") }
    var autoSaving by remember { mutableStateOf(true) }
    var frequency by remember { mutableStateOf("Semanal") }
    var autoAmountText by remember { mutableStateOf("100000") }
    var errorMessage by remember { mutableStateOf("") }
    var showSuccessDialog by remember { mutableStateOf(false) }

    val goal = goalText.toIntOrNull() ?: 0
    val autoAmount = autoAmountText.toIntOrNull() ?: 0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KibuWhite)
    ) {
        GreenHeader(
            title = "Nuevo bolsillo",
            onBack = onBack
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 22.dp)
        ) {
            FieldLabel("Nombre")

            OutlinedTextField(
                value = name,
                onValueChange = {
                    name = it
                    errorMessage = ""
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(14.dp))

            FieldLabel("Meta")

            OutlinedTextField(
                value = goalText,
                onValueChange = {
                    goalText = it.filter { char -> char.isDigit() }
                    errorMessage = ""
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FieldLabel("Autoahorro")

                Spacer(modifier = Modifier.weight(1f))

                Switch(
                    checked = autoSaving,
                    onCheckedChange = { autoSaving = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = KibuWhite,
                        checkedTrackColor = KibuGreen
                    )
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            FieldLabel("¿Con qué frecuencia deseas ahorrar?")

            SelectMock(
                text = frequency,
                onClick = {
                    frequency = if (frequency == "Semanal") "Mensual" else "Semanal"
                }
            )

            Spacer(modifier = Modifier.height(14.dp))

            FieldLabel("¿Cuánto?")

            SelectMock(
                text = formatMoney(autoAmount),
                onClick = {
                    autoAmountText = if (autoAmountText == "100000") "50000" else "100000"
                }
            )

            if (errorMessage.isNotEmpty()) {
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = errorMessage,
                    color = Color.Red,
                    fontSize = 13.sp
                )
            }

            Spacer(modifier = Modifier.height(26.dp))

            Button(
                onClick = {
                    when {
                        name.isBlank() -> errorMessage = "Ingresa el nombre del bolsillo"
                        goal <= 0 -> errorMessage = "Ingresa una meta válida"
                        autoSaving && autoAmount <= 0 -> errorMessage = "Ingresa un valor de autoahorro válido"
                        else -> showSuccessDialog = true
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(7.dp),
                colors = ButtonDefaults.buttonColors(containerColor = KibuGreen)
            ) {
                Text(
                    text = "Crear",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

    if (showSuccessDialog) {
        AlertDialog(
            onDismissRequest = {},
            containerColor = Color(0xFFD9D9D9),
            title = {},
            text = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .background(KibuWhite, RoundedCornerShape(18.dp))
                            .padding(horizontal = 28.dp, vertical = 14.dp)
                    ) {
                        Text(
                            text = "Bolsillo creado\nexitosamente",
                            color = Color.Black,
                            fontSize = 25.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 27.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(28.dp))

                    Button(
                        onClick = {
                            showSuccessDialog = false

                            onPocketCreated(
                                SavingPocket(
                                    name = name,
                                    goal = goal,
                                    currentAmount = 0,
                                    autoSaving = autoSaving,
                                    frequency = frequency,
                                    autoAmount = autoAmount
                                )
                            )
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = KibuGreen),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        Text("Aceptar")
                    }
                }
            },
            confirmButton = {}
        )
    }
}