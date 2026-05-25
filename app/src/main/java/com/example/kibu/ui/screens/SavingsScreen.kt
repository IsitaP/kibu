package com.example.kibu.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kibu.navigation.AppScreen
import com.example.kibu.ui.components.KibuBackButton
import com.example.kibu.ui.components.KibuBottomBar
import com.example.kibu.ui.components.KibuSmallLogo
import com.example.kibu.ui.theme.*

@Composable
fun SavingsScreen(
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
                .height(185.dp)
                .background(KibuGreen)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 18.dp, top = 38.dp)
            ) {
                KibuBackButton(onClick = onBack)
            }

            Text(
                text = "Ahorros",
                color = KibuWhite,
                fontSize = 38.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 24.dp, bottom = 22.dp)
            )

            Box(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 30.dp)
                    .background(KibuWhite)
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            ) {
                KibuSmallLogo()
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "\$820.000",
                color = Color.Black,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Ahorros totales",
                color = KibuGray,
                fontSize = 17.sp
            )

            Spacer(modifier = Modifier.height(18.dp))

            SavingPocketCard(
                title = "Fondo de emergencia",
                amount = "\$500,000"
            )

            Spacer(modifier = Modifier.height(14.dp))

            SavingPocketCard(
                title = "Metas",
                amount = "\$320,000"
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp),
                shape = RoundedCornerShape(7.dp),
                colors = ButtonDefaults.buttonColors(containerColor = KibuGreen)
            ) {
                Text(
                    text = "Crear bolsillo",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        KibuBottomBar(
            currentScreen = AppScreen.SAVINGS,
            onNav = onNav
        )
    }
}

@Composable
private fun SavingPocketCard(
    title: String,
    amount: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(94.dp),
        colors = CardDefaults.cardColors(containerColor = KibuWhite),
        border = BorderStroke(1.dp, KibuBorder),
        shape = RoundedCornerShape(9.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp, vertical = 16.dp)
        ) {
            Row {
                Text(
                    text = title,
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = amount,
                    color = Color.Black,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .background(KibuGreen, RoundedCornerShape(20.dp))
                    .padding(horizontal = 16.dp, vertical = 5.dp)
            ) {
                Text(
                    text = "Activo",
                    color = KibuWhite,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}