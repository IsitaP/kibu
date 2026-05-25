package com.example.kibu.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kibu.navigation.AppScreen
import com.example.kibu.ui.components.KibuBottomBar
import com.example.kibu.ui.components.KibuSmallLogo
import com.example.kibu.ui.theme.*

@Composable
fun InvestmentScreen(
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
                .height(54.dp)
                .background(KibuGreen)
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 26.dp)
        ) {
            Spacer(modifier = Modifier.height(18.dp))

            Button(
                onClick = onBack,
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2F5CC8)),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 3.dp)
            ) {
                Text(
                    text = "← Volver al menú principal",
                    fontSize = 13.sp
                )
            }

            Spacer(modifier = Modifier.height(36.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Desde el equipo de\ntenemos que decirte algo...",
                    color = Color(0xFF2C2C2C),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 29.sp
                )

                Spacer(modifier = Modifier.weight(1f))

                KibuSmallLogo()
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "¡El momento\nde invertir es\nahora!",
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF2A2A2A),
                fontSize = 39.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                lineHeight = 47.sp
            )

            Spacer(modifier = Modifier.height(28.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(158.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F8F8)),
                border = BorderStroke(1.dp, KibuBorder),
                shape = RoundedCornerShape(2.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp)
                ) {
                    Text(
                        text = "Las inversiones son una increíble oportunidad para\ngenerar ingresos a partir de tu dinero",
                        color = KibuGray,
                        fontSize = 11.sp
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "\$",
                            fontSize = 39.sp
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(containerColor = KibuOrange),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Text("Conocer más")
                        }

                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = "\$",
                            fontSize = 39.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(26.dp))

            Row {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "↗",
                        color = KibuOrange,
                        fontSize = 46.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "🤝",
                        fontSize = 38.sp
                    )
                }

                Spacer(modifier = Modifier.width(22.dp))

                Column {
                    Text(
                        text = "Ofrecemos",
                        color = Color(0xFF2A2A2A),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "• CDT a diferentes plazos\n• Inversión a microempresas aliadas\n• Compra de acciones\n  próximamente",
                        color = Color.Black,
                        fontSize = 15.sp,
                        lineHeight = 19.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        KibuBottomBar(
            currentScreen = AppScreen.INVESTMENT,
            onNav = onNav
        )
    }
}