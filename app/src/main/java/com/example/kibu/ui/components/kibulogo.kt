package com.example.kibu.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kibu.ui.theme.KibuBlue
import com.example.kibu.ui.theme.KibuGreen
import com.example.kibu.ui.theme.KibuWhite

@Composable
fun KibuLogo() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(KibuGreen),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "K",
                color = KibuWhite,
                fontSize = 38.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.width(14.dp))

        Text(
            text = "Kibu",
            color = KibuBlue,
            fontSize = 46.sp,
            fontWeight = FontWeight.Bold
        )
    }
}