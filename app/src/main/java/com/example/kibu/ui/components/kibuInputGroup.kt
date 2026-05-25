package com.example.kibu.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kibu.ui.theme.KibuBlue
import com.example.kibu.ui.theme.KibuBorder
import com.example.kibu.ui.theme.KibuPlaceholder
import com.example.kibu.ui.theme.KibuTextDark

@Composable
fun KibuInputGroup(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(132.dp)
            .border(
                width = 1.dp,
                color = KibuBorder,
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))
    ) {
        KibuInputField(
            value = email,
            placeholder = "Email",
            onValueChange = onEmailChange,
            modifier = Modifier.weight(1f)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(KibuBorder)
        )

        KibuInputField(
            value = password,
            placeholder = "Password",
            onValueChange = onPasswordChange,
            isPassword = true,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun KibuInputField(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isPassword: Boolean = false
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            textStyle = TextStyle(
                color = KibuTextDark,
                fontSize = 20.sp
            ),
            cursorBrush = SolidColor(KibuBlue),
            visualTransformation = if (isPassword) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                if (value.isEmpty()) {
                    Text(
                        text = placeholder,
                        color = KibuPlaceholder,
                        fontSize = 20.sp
                    )
                }
                innerTextField()
            }
        )
    }
}