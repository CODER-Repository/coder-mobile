package com.coder.siakad.presentation.navigation

sealed class Screen(val route: String) {
    data object Login : Screen("login")
    data object Dashboard : Screen("dashboard")
    data object Schedule : Screen("schedule")
    data object Attendance : Screen("attendance")
}