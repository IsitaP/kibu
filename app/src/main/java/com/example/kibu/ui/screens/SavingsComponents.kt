package com.example.kibu.ui.screens.savings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.kibu.ui.components.KibuBackButton
import com.example.kibu.ui.theme.*

@Composable
fun GreenHeader(
    title: String,
    onBack: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(134.dp)
            .background(KibuGreen)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 20.dp)
        ) {
            KibuBackButton(onClick = onBack)
        }

        Text(
            text = title,
            color = KibuWhite,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun FieldLabel(text: String) {
    Text(
        text = text,
        color = Color(0xFF222222),
        fontSize = 17.sp
    )
}

@Composable
fun SelectMock(
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .border(1.dp, Color(0xFF9EA0A5), RoundedCornerShape(7.dp))
            .clickable { onClick() }
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = text,
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
}

@Composable
fun SavingPocketCard(
    title: String,
    amount: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(94.dp)
            .clickable { onClick() },
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

@Composable
fun MovementRow(movement: Movement) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Column {
            Text(
                text = movement.title,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = movement.date,
                color = Color(0xFF444444),
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = formatMoney(movement.amount),
            color = KibuGreen,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

fun formatMoney(value: Int): String {
    val text = value.toString()
        .reversed()
        .chunked(3)
        .joinToString(".")
        .reversed()

    return "$$text"
}

