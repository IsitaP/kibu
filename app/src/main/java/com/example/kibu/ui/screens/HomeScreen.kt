package com.example.kibu.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.kibu.ui.components.*
import com.example.kibu.ui.theme.*

@Composable
fun HomeScreen(
    onNav: (AppScreen) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KibuWhite)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(42.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                KibuHomeLogo()

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "↪",
                    color = KibuDarkGreen,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Hola, Santiago",
                color = KibuTextDark,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(18.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(104.dp),
                colors = CardDefaults.cardColors(containerColor = KibuWhite),
                border = BorderStroke(1.dp, KibuBorder)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 18.dp, vertical = 14.dp)
                ) {
                    Text(
                        text = "Saldo total",
                        color = Color.Black,
                        fontSize = 17.sp
                    )

                    Text(
                        text = "\$3.500.00",
                        color = KibuTextDark,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    HomeOptionCard(
                        icon = "▷",
                        label = "Aprendizaje",
                        color = KibuPurple,
                        onClick = {}
                    )
                }

                Box(modifier = Modifier.weight(1f)) {
                    HomeOptionCard(
                        icon = "↗",
                        label = "Invertir",
                        color = KibuOrange,
                        onClick = { onNav(AppScreen.INVESTMENT) }
                    )
                }

                Box(modifier = Modifier.weight(1f)) {
                    HomeOptionCard(
                        icon = "♟",
                        label = "Ahorro",
                        color = KibuGreen,
                        onClick = { onNav(AppScreen.SAVINGS) }
                    )
                }

                Box(modifier = Modifier.weight(1f)) {
                    HomeOptionCard(
                        icon = "〽",
                        label = "Microcrédito",
                        color = Color.Red,
                        onClick = { onNav(AppScreen.MICROCREDIT) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Posibilidades para ti",
                color = Color.Black,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            RecommendationCard(
                icon = "🎓",
                title = "Aprende sobre finanzas",
                subtitle = "Accede a cursos educativos",
                color = KibuPurple,
                onClick = {}
            )

            Spacer(modifier = Modifier.height(8.dp))

            RecommendationCard(
                icon = "🤝",
                title = "Invierte desde \$1.000",
                subtitle = "Comienza a Invertir fácilmente",
                color = KibuOrange,
                onClick = { onNav(AppScreen.INVESTMENT) }
            )

            Spacer(modifier = Modifier.height(8.dp))

            RecommendationCard(
                icon = "♟",
                title = "Abre un ahorro",
                subtitle = "Construye tu reserva financiera",
                color = KibuGreen,
                onClick = { onNav(AppScreen.SAVINGS) }
            )

            Spacer(modifier = Modifier.height(18.dp))
        }

        KibuBottomBar(
            currentScreen = AppScreen.HOME,
            onNav = onNav
        )
    }
}