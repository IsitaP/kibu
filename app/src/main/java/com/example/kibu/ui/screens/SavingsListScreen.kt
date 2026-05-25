package com.example.kibu.ui.screens.savings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun SavingsListScreen(
    pockets: List<SavingPocket>,
    onBack: () -> Unit,
    onNav: (AppScreen) -> Unit,
    onCreatePocket: () -> Unit,
    onOpenPocket: (Int) -> Unit
) {
    val totalSavings = pockets.sumOf { it.currentAmount }

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
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = formatMoney(totalSavings),
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

            pockets.forEachIndexed { index, pocket ->
                SavingPocketCard(
                    title = pocket.name,
                    amount = formatMoney(pocket.currentAmount),
                    onClick = { onOpenPocket(index) }
                )

                Spacer(modifier = Modifier.height(14.dp))
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = onCreatePocket,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(7.dp),
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