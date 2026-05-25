package com.example.kibu.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import com.example.kibu.navigation.AppScreen
import com.example.kibu.ui.components.KibuAvatar
import com.example.kibu.ui.components.KibuBackButton
import com.example.kibu.ui.components.KibuBottomBar
import com.example.kibu.ui.components.KibuSmallLogo
import com.example.kibu.ui.theme.KibuBorder
import com.example.kibu.ui.theme.KibuDarkGreen
import com.example.kibu.ui.theme.KibuPurple
import com.example.kibu.ui.theme.KibuWhite

@Composable
fun MicrocreditScreen(
    onBack: () -> Unit,
    onNav: (AppScreen) -> Unit
) {
    var amountText by remember { mutableStateOf("200000") }
    var monthsText by remember { mutableStateOf("6") }
    var showDialog by remember { mutableStateOf(false) }

    val amount = amountText.toIntOrNull() ?: 0
    val months = monthsText.toIntOrNull() ?: 0
    val interestRate = 0.12

    val isValidAmount = amount in 100000..250000
    val isValidMonths = months in 3..9
    val totalToPay = amount + (amount * interestRate)
    val monthlyPayment = if (months > 0) totalToPay / months else 0.0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KibuWhite)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(KibuDarkGreen)
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                KibuBackButton(onClick = onBack)

                Spacer(modifier = Modifier.weight(1f))

                KibuSmallLogo()
            }

            Spacer(modifier = Modifier.height(32.dp))

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                KibuAvatar()
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Tienes 17 puntos de Kibu Score, puedes\nacceder a un microcrédito con las\nsiguientes opciones",
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                lineHeight = 23.sp
            )

            Spacer(modifier = Modifier.height(22.dp))

            LoanRangeMock()

            Spacer(modifier = Modifier.height(18.dp))

            OutlinedTextField(
                value = amountText,
                onValueChange = { value ->
                    amountText = value.filter { it.isDigit() }
                },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Monto del microcrédito") },
                placeholder = { Text("Entre 100000 y 250000") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                isError = amountText.isNotEmpty() && !isValidAmount
            )

            if (amountText.isNotEmpty() && !isValidAmount) {
                Text(
                    text = "El monto debe estar entre $100.000 y $250.000",
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = monthsText,
                onValueChange = { value ->
                    monthsText = value.filter { it.isDigit() }
                },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Meses") },
                placeholder = { Text("Entre 3 y 9 meses") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                isError = monthsText.isNotEmpty() && !isValidMonths
            )

            if (monthsText.isNotEmpty() && !isValidMonths) {
                Text(
                    text = "El plazo debe estar entre 3 y 9 meses",
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            FieldMock(
                label = "Tasa de interés fija",
                value = "12%"
            )

            Spacer(modifier = Modifier.height(18.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Simulación del crédito",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Monto solicitado: ${formatMoney(amount)}",
                        color = Color.Black,
                        fontSize = 14.sp
                    )

                    Text(
                        text = "Total con interés: ${formatMoney(totalToPay.toInt())}",
                        color = Color.Black,
                        fontSize = 14.sp
                    )

                    Text(
                        text = "Cuota mensual aproximada: ${formatMoney(monthlyPayment.toInt())}",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = KibuPurple)
                ) {
                    Text(
                        text = "¡Quiero sumar más!",
                        fontSize = 13.sp
                    )
                }

                Button(
                    onClick = {
                        if (isValidAmount && isValidMonths) {
                            showDialog = true
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp),
                    shape = RoundedCornerShape(5.dp),
                    enabled = isValidAmount && isValidMonths,
                    colors = ButtonDefaults.buttonColors(containerColor = KibuPurple)
                ) {
                    Text(
                        text = "Solicitar",
                        fontSize = 13.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))
        }

        KibuBottomBar(
            currentScreen = AppScreen.MICROCREDIT,
            onNav = onNav
        )
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = {
                Text(text = "Solicitud enviada")
            },
            text = {
                Text(
                    text = "Tu solicitud de microcrédito por ${formatMoney(amount)} fue registrada. Cuota aproximada: ${formatMoney(monthlyPayment.toInt())} mensuales."
                )
            },
            confirmButton = {
                TextButton(
                    onClick = { showDialog = false }
                ) {
                    Text("Aceptar")
                }
            }
        )
    }
}

@Composable
private fun LoanRangeMock() {
    Column {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "100.000",
                color = KibuDarkGreen,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "250.000",
                color = KibuDarkGreen,
                fontSize = 14.sp
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(Color(0xFF8AD4A7))
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 14.dp)
                    .size(width = 32.dp, height = 20.dp)
                    .background(KibuWhite, RoundedCornerShape(12.dp))
            )
        }
    }
}

@Composable
private fun FieldMock(
    label: String,
    value: String
) {
    Column {
        Text(
            text = label,
            color = Color(0xFF3D3D3D),
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(7.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .border(1.dp, KibuBorder, RoundedCornerShape(7.dp))
                .padding(horizontal = 14.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = value,
                color = Color(0xFF3D3D3D),
                fontSize = 13.sp
            )
        }
    }
}

private fun formatMoney(value: Int): String {
    val text = value.toString()
        .reversed()
        .chunked(3)
        .joinToString(".")
        .reversed()

    return "$$text"
}