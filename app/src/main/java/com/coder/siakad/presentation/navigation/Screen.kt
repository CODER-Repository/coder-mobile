package com.coder.siakad.presentation.navigation

sealed class Screen(val route: String) {
    data object Login : Screen("login")
    data object Dashboard : Screen("dashboard")
    data object Schedule : Screen("schedule")
    data object Attendance : Screen("attendance")
    data object Profile : Screen("profile")
    data object EditProfile: Screen("editProfile")
    data object AcademicFees: Screen("academicFees")
    data object Presensi: Screen("presensi")
}