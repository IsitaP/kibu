package com.example.kibu.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kibu.ui.components.KibuButton
import com.example.kibu.ui.components.KibuInputGroup
import com.example.kibu.ui.components.KibuLogo
import com.example.kibu.ui.theme.KibuBlue
import com.example.kibu.ui.theme.KibuTextDark
import com.example.kibu.ui.theme.KibuWhite

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit = {},
    onForgotPasswordClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KibuWhite)
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(95.dp))

        KibuLogo()

        Spacer(modifier = Modifier.height(62.dp))

        KibuInputGroup(
            email = email,
            password = password,
            onEmailChange = { email = it },
            onPasswordChange = { password = it }
        )

        Spacer(modifier = Modifier.height(20.dp))

        KibuButton(
            text = "Log in",
            onClick = onLoginClick
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Forgot password?",
            color = KibuBlue,
            fontSize = 19.sp,
            modifier = Modifier.clickable {
                onForgotPasswordClick()
            }
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Don’t have an account?",
            color = KibuTextDark,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Sign up",
            color = KibuBlue,
            fontSize = 21.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.clickable {
                onSignUpClick()
            }
        )

        Spacer(modifier = Modifier.height(70.dp))
    }
}