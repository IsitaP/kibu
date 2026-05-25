package com.example.kibu.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kibu.navigation.AppScreen
import com.example.kibu.ui.components.*
import com.example.kibu.ui.theme.*

@Composable
fun MicrocreditScreen(
    onBack: () -> Unit,
    onNav: (AppScreen) -> Unit
) {
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

            Spacer(modifier = Modifier.height(42.dp))

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                KibuAvatar()
            }

            Spacer(modifier = Modifier.height(34.dp))

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

            FieldMock(
                label = "Meses",
                value = "Escoge entre 3 y 9 meses"
            )

            Spacer(modifier = Modifier.height(18.dp))

            FieldMock(
                label = "Tasa de interés fija",
                value = "12%"
            )

            Spacer(modifier = Modifier.height(50.dp))

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
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = KibuPurple)
                ) {
                    Text(
                        text = "Solicitar Microcrédito",
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