package com.example.kibu.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.kibu.ui.screens.HomeScreen
import com.example.kibu.ui.screens.InvestmentScreen
import com.example.kibu.ui.screens.LoginScreen
import com.example.kibu.ui.screens.MicrocreditScreen
import com.example.kibu.ui.screens.ScoreScreen
import com.example.kibu.ui.screens.savings.SavingsScreen

enum class AppScreen {
    LOGIN,
    HOME,
    MICROCREDIT,
    SAVINGS,
    INVESTMENT,
    SCORE
}

@Composable
fun AppNavigation() {
    var currentScreen by remember { mutableStateOf(AppScreen.LOGIN) }

    when (currentScreen) {
        AppScreen.LOGIN -> {
            LoginScreen(
                onLoginClick = {
                    currentScreen = AppScreen.HOME
                }
            )
        }

        AppScreen.HOME -> {
            HomeScreen(
                onNav = { screen ->
                    currentScreen = screen
                }
            )
        }

        AppScreen.MICROCREDIT -> {
            MicrocreditScreen(
                onBack = {
                    currentScreen = AppScreen.HOME
                },
                onNav = { screen ->
                    currentScreen = screen
                }
            )
        }

        AppScreen.SAVINGS -> {
            SavingsScreen(
                onBack = {
                    currentScreen = AppScreen.HOME
                },
                onNav = { screen ->
                    currentScreen = screen
                }
            )
        }

        AppScreen.INVESTMENT -> {
            InvestmentScreen(
                onBack = {
                    currentScreen = AppScreen.HOME
                },
                onNav = { screen ->
                    currentScreen = screen
                }
            )
        }

        AppScreen.SCORE -> {
            ScoreScreen(
                onBack = {
                    currentScreen = AppScreen.HOME
                },
                onNav = { screen ->
                    currentScreen = screen
                }
            )
        }
    }
}