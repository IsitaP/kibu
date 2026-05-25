package com.example.kibu.ui.screens.savings

data class SavingPocket(
    val name: String,
    val goal: Int,
    val currentAmount: Int,
    val autoSaving: Boolean,
    val frequency: String,
    val autoAmount: Int
)

data class Movement(
    val title: String,
    val date: String,
    val amount: Int
)

enum class SavingsFlowScreen {
    LIST,
    CREATE,
    DETAIL,
    ADD_MONEY
}
