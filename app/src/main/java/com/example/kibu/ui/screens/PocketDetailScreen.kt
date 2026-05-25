package com.example.kibu.ui.screens.savings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kibu.ui.theme.*

@Composable
fun PocketDetailScreen(
    pocket: SavingPocket,
    movements: List<Movement>,
    onBack: () -> Unit,
    onAddMoney: () -> Unit
) {
    val progress = if (pocket.goal > 0) {
        pocket.currentAmount.toFloat() / pocket.goal.toFloat()
    } else {
        0f
    }.coerceIn(0f, 1f)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KibuWhite)
    ) {
        GreenHeader(
            title = pocket.name,
            onBack = onBack
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp, vertical = 28.dp)
        ) {
            Text(
                text = formatMoney(pocket.currentAmount),
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black,
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Text(
                text = "Meta: ${formatMoney(pocket.goal)}",
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF444444),
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(22.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(14.dp)
                    .background(Color(0xFFDDF4E9), RoundedCornerShape(20.dp))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(progress)
                        .height(14.dp)
                        .background(KibuGreen, RoundedCornerShape(20.dp))
                )
            }

            Spacer(modifier = Modifier.height(38.dp))

            Text(
                text = "Movimientos",
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            movements.forEach { movement ->
                MovementRow(movement)
                Spacer(modifier = Modifier.height(22.dp))
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onAddMoney,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp),
                shape = RoundedCornerShape(7.dp),
                colors = ButtonDefaults.buttonColors(containerColor = KibuGreen)
            ) {
                Text(
                    text = "Agregar dinero",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(28.dp))
        }
    }
}