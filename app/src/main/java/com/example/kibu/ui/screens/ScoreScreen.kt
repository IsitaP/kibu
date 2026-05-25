package com.example.kibu.ui.screens

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
import com.example.kibu.ui.components.*
import com.example.kibu.ui.theme.*

@Composable
fun ScoreScreen(
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
                .height(55.dp)
                .background(KibuGreen)
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(18.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                KibuBackButton(onClick = onBack)

                Spacer(modifier = Modifier.weight(1f))

                KibuSmallLogo()

                Spacer(modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(42.dp))

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                KibuAvatar()
            }

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "Resumen de cuenta",
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(26.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .width(168.dp)
                        .height(164.dp),
                    colors = CardDefaults.cardColors(containerColor = KibuSoftGreen),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(18.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "KIBU Score",
                            color = Color.Black,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(88.dp)
                                .background(KibuWhite, RoundedCornerShape(12.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "17",
                                color = Color.Black,
                                fontSize = 42.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))

                Button(
                    onClick = { onNav(AppScreen.MICROCREDIT) },
                    modifier = Modifier
                        .weight(1f)
                        .height(68.dp),
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2D58BD))
                ) {
                    Text(
                        text = "Acceder a microcrédito",
                        fontSize = 13.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(26.dp))

            Text(
                text = "Historial de puntaje",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(104.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFEAEAEA)),
                shape = RoundedCornerShape(14.dp)
            ) {
                Column(
                    modifier = Modifier.padding(12.dp)
                ) {
                    HistoryLine("15/10/2025: Depósito en el ahorro “Iphone”", "+10")
                    HistoryLine("01/10/2025: Transferencia a cuenta Nequi", "+1")
                    HistoryLine("30/09/2025: Transferencia a cuenta Nequi", "+1")
                    HistoryLine("30/09/2025: Examen 1-Finanzas personales", "+5")
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(68.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFEAEAEA)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "🎓 Cursos iniciados: 7\n✅ Cursos completados: 4\n⭐ Puntos acumulados: 120 pts\n🏆 Liga actual: Liga Diamante",
                    modifier = Modifier.padding(10.dp),
                    fontSize = 10.sp,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        KibuBottomBar(
            currentScreen = AppScreen.SCORE,
            onNav = onNav
        )
    }
}

@Composable
private fun HistoryLine(
    text: String,
    points: String
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = text,
            modifier = Modifier.weight(1f),
            color = Color.Black,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = points,
            color = Color.Black,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
        )
    }

    Spacer(modifier = Modifier.height(5.dp))
}