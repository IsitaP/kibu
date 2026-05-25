package com.example.kibu.ui.screens.savings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kibu.ui.theme.KibuWhite

@Composable
fun AddMoneyScreen(
    pocketName: String,
    onBack: () -> Unit,
    onContinue: (Int) -> Unit
) {
    var amountText by remember { mutableStateOf("100000") }
    var errorMessage by remember { mutableStateOf("") }

    val amount = amountText.toIntOrNull() ?: 0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KibuWhite)
    ) {
        GreenHeader(
            title = pocketName,
            onBack = onBack
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 42.dp, vertical = 32.dp)
        ) {
            Text(
                text = "Add Money",
                color = Color.Black,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(26.dp))

            Text(
                text = "Amount",
                color = Color.Black,
                fontSize = 21.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = amountText,
                onValueChange = {
                    amountText = it.filter { char -> char.isDigit() }
                    errorMessage = ""
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(88.dp),
                singleLine = true,
                textStyle = TextStyle(
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            if (errorMessage.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = errorMessage,
                    color = Color.Red,
                    fontSize = 13.sp
                )
            }

            Spacer(modifier = Modifier.height(34.dp))

            Button(
                onClick = {
                    if (amount <= 0) {
                        errorMessage = "Ingresa un monto válido"
                    } else {
                        onContinue(amount)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0876F8))
            ) {
                Text(
                    text = "Continue",
                    fontSize = 21.sp
                )
            }
        }
    }
}
