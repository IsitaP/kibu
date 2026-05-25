package com.example.kibu.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kibu.navigation.AppScreen
import com.example.kibu.ui.theme.*

@Composable
fun KibuHomeLogo() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(KibuGreen),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "K",
                color = KibuWhite,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = "Kibu",
            color = KibuBlue,
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun KibuSmallLogo() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(25.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(KibuGreen),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "↗",
                color = KibuWhite,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = "Kibu",
            color = KibuBlue,
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun KibuBackButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(34.dp)
            .clip(CircleShape)
            .background(KibuDarkGreen.copy(alpha = 0.15f))
            .border(1.dp, KibuDarkGreen, CircleShape)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "←",
            color = KibuDarkGreen,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun KibuAvatar() {
    Box(
        modifier = Modifier
            .size(86.dp)
            .clip(CircleShape)
            .background(KibuSoftGreen),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "🧑‍🚀",
            fontSize = 42.sp
        )
    }
}

@Composable
fun KibuBottomBar(
    currentScreen: AppScreen,
    onNav: (AppScreen) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .background(KibuWhite)
            .border(1.dp, KibuBorder),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomItem("⌂", "Inicio", currentScreen == AppScreen.HOME) {
            onNav(AppScreen.HOME)
        }

        BottomItem("〽", "Microcrédito", currentScreen == AppScreen.MICROCREDIT) {
            onNav(AppScreen.MICROCREDIT)
        }

        BottomItem("♟", "Ahorro", currentScreen == AppScreen.SAVINGS) {
            onNav(AppScreen.SAVINGS)
        }

        BottomItem("↗", "Inversión", currentScreen == AppScreen.INVESTMENT) {
            onNav(AppScreen.INVESTMENT)
        }

        BottomItem("●", "Perfil", currentScreen == AppScreen.SCORE) {
            onNav(AppScreen.SCORE)
        }
    }
}

@Composable
private fun RowScope.BottomItem(
    icon: String,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val color = if (selected) KibuBlue else Color(0xFF4D4D4D)

    Column(
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = icon,
            color = color,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = label,
            color = color,
            fontSize = 11.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun HomeOptionCard(
    icon: String,
    label: String,
    color: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .height(80.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(9.dp),
        colors = CardDefaults.cardColors(containerColor = KibuWhite),
        border = BorderStroke(1.dp, KibuBorder)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = icon,
                color = color,
                fontSize = 31.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = label,
                color = Color.Black,
                fontSize = 11.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun RecommendationCard(
    icon: String,
    title: String,
    subtitle: String,
    color: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(74.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = KibuWhite),
        border = BorderStroke(1.dp, KibuBorder)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = icon,
                color = color,
                fontSize = 34.sp
            )

            Spacer(modifier = Modifier.width(18.dp))

            Column {
                Text(
                    text = title,
                    color = Color.Black,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = subtitle,
                    color = Color.Black,
                    fontSize = 14.sp
                )
            }
        }
    }
}