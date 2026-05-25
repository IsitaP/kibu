package com.example.kibu.ui.screens.savings

import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateListOf
import com.example.kibu.navigation.AppScreen

@Composable
fun SavingsScreen(
    onBack: () -> Unit,
    onNav: (AppScreen) -> Unit
) {
    var currentScreen by remember { mutableStateOf(SavingsFlowScreen.LIST) }
    var selectedPocketIndex by remember { mutableStateOf(0) }

    val pockets = remember {
        mutableStateListOf(
            SavingPocket(
                name = "Fondo de emergencia",
                goal = 700000,
                currentAmount = 500000,
                autoSaving = true,
                frequency = "Mensual",
                autoAmount = 50000
            ),
            SavingPocket(
                name = "Metas",
                goal = 1200000,
                currentAmount = 320000,
                autoSaving = false,
                frequency = "Semanal",
                autoAmount = 100000
            )
        )
    }

    val movements = remember {
        mutableStateListOf(
            Movement("Depósito", "10 abril", 100000),
            Movement("Depósito", "3 abril", 111000),
            Movement("Depósito", "1 abril", 110000)
        )
    }

    when (currentScreen) {
        SavingsFlowScreen.LIST -> {
            SavingsListScreen(
                pockets = pockets,
                onBack = onBack,
                onNav = onNav,
                onCreatePocket = {
                    currentScreen = SavingsFlowScreen.CREATE
                },
                onOpenPocket = { index ->
                    selectedPocketIndex = index
                    currentScreen = SavingsFlowScreen.DETAIL
                }
            )
        }

        SavingsFlowScreen.CREATE -> {
            NewPocketScreen(
                onBack = {
                    currentScreen = SavingsFlowScreen.LIST
                },
                onPocketCreated = { newPocket ->
                    pockets.add(newPocket)
                    selectedPocketIndex = pockets.lastIndex
                    currentScreen = SavingsFlowScreen.DETAIL
                }
            )
        }

        SavingsFlowScreen.DETAIL -> {
            PocketDetailScreen(
                pocket = pockets[selectedPocketIndex],
                movements = movements,
                onBack = {
                    currentScreen = SavingsFlowScreen.LIST
                },
                onAddMoney = {
                    currentScreen = SavingsFlowScreen.ADD_MONEY
                }
            )
        }

        SavingsFlowScreen.ADD_MONEY -> {
            AddMoneyScreen(
                pocketName = pockets[selectedPocketIndex].name,
                onBack = {
                    currentScreen = SavingsFlowScreen.DETAIL
                },
                onContinue = { amount ->
                    val currentPocket = pockets[selectedPocketIndex]

                    pockets[selectedPocketIndex] = currentPocket.copy(
                        currentAmount = currentPocket.currentAmount + amount
                    )

                    movements.add(
                        0,
                        Movement(
                            title = "Depósito",
                            date = "Hoy",
                            amount = amount
                        )
                    )

                    currentScreen = SavingsFlowScreen.DETAIL
                }
            )
        }
    }
}