package com.coder.siakad.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coder.siakad.presentation.navigation.Screen
import com.coder.siakad.presentation.screen.attendance.AttendanceScreen
import com.coder.siakad.presentation.screen.dashboard.DashboardScreen
import com.coder.siakad.presentation.screen.login.LoginScreen
import com.coder.siakad.presentation.screen.login.LoginViewModel
import com.coder.siakad.presentation.screen.schedule.ScheduleScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiakadApp(
    navController: NavHostController = rememberNavController(),
    viewModel: LoginViewModel = hiltViewModel()
) {
    // For this week, because we haven't install Navigation, just put your Screen in this
    // if you wanted to test your screen in emulator

    // ex :
//   DashboardScreen()
//    ProfileScreen(title = "Profile", navigateBack = {}, modifier = Modifier)
//     ScheduleScreen()

    //and comment the code below to test your screen
    Scaffold { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            modifier = Modifier.padding(contentPadding)
        ) {
            composable(Screen.Login.route) {
                LoginScreen(navigateToDashboard = { navController.navigate(Screen.Dashboard.route) })
            }
            composable(Screen.Dashboard.route) {
                DashboardScreen(
                    onLogout = { navController.navigateUp() },
                    menuButtonHandler = listOf(
                        { navController.navigate(Screen.Schedule.route) },
                        { navController.navigate(Screen.Attendance.route)},
                        {},
                        {},
                        {}
                    )
                )
            }
            composable(Screen.Schedule.route) {
                ScheduleScreen()
            }
            composable(Screen.Attendance.route){
                AttendanceScreen()
            }
        }
    }
}