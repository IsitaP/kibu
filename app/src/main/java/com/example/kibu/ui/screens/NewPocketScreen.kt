package com.example.kibu.ui.screens.savings

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kibu.ui.theme.KibuGray
import com.example.kibu.ui.theme.KibuGreen
import com.example.kibu.ui.theme.KibuWhite

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
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                leadingIcon = {
                    Text("$")
                },
                placeholder = {
                    Text("Ej: 1500000")
                }
            )

            if (goalText.isNotBlank()) {
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Meta ingresada: ${formatMoney(goal)}",
                    color = KibuGray,
                    fontSize = 13.sp
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FieldLabel("Autoahorro")

                Spacer(modifier = Modifier.weight(1f))

                Switch(
                    checked = autoSaving,
                    onCheckedChange = {
                        autoSaving = it
                        errorMessage = ""
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = KibuWhite,
                        checkedTrackColor = KibuGreen
                    )
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            FieldLabel("¿Con qué frecuencia deseas ahorrar?")

            FrequencyDropdown(
                selectedFrequency = frequency,
                onFrequencySelected = { selected ->
                    frequency = selected
                    errorMessage = ""
                }
            )

            Spacer(modifier = Modifier.height(14.dp))

            FieldLabel("¿Cuánto?")

            OutlinedTextField(
                value = autoAmountText,
                onValueChange = { value ->
                    autoAmountText = value.filter { char -> char.isDigit() }
                    errorMessage = ""
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                leadingIcon = {
                    Text("$")
                },
                placeholder = {
                    Text("Ej: 100000")
                }
            )

            if (autoAmountText.isNotBlank()) {
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Valor ingresado: ${formatMoney(autoAmount)}",
                    color = KibuGray,
                    fontSize = 13.sp
                )
            }

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
                        name.isBlank() -> {
                            errorMessage = "Ingresa el nombre del bolsillo"
                        }

                        goal <= 0 -> {
                            errorMessage = "Ingresa una meta válida"
                        }

                        autoSaving && autoAmount <= 0 -> {
                            errorMessage = "Ingresa un valor de autoahorro válido"
                        }

                        else -> {
                            showSuccessDialog = true
                        }
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
                                    name = name.trim(),
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

@Composable
private fun FrequencyDropdown(
    selectedFrequency: String,
    onFrequencySelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    val options = listOf(
        "Diario",
        "Semanal",
        "Quincenal",
        "Mensual"
    )

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFF9EA0A5),
                    shape = RoundedCornerShape(7.dp)
                )
                .clickable {
                    expanded = true
                }
                .padding(horizontal = 12.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = selectedFrequency,
                color = Color.Black,
                fontSize = 20.sp
            )

            Text(
                text = "⌄",
                color = Color.Black,
                fontSize = 26.sp,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Text(option)
                    },
                    onClick = {
                        onFrequencySelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}