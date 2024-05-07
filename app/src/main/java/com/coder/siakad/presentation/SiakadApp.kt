package com.coder.siakad.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.coder.siakad.presentation.component.BottomBar
import com.coder.siakad.presentation.component.NavBar
import com.coder.siakad.presentation.navigation.Screen
import com.coder.siakad.presentation.screen.MaintenanceScreen
import com.coder.siakad.presentation.screen.academicFees.AcademicFeesScreen
import com.coder.siakad.presentation.screen.attendance.AttendanceScreen
import com.coder.siakad.presentation.screen.dashboard.DashboardScreen
import com.coder.siakad.presentation.screen.krs.KrsScreen
import com.coder.siakad.presentation.screen.login.LoginScreen
import com.coder.siakad.presentation.screen.login.LoginViewModel
import com.coder.siakad.presentation.screen.presensi.PresensiFormScreen
import com.coder.siakad.presentation.screen.profile.ProfileScreen
import com.coder.siakad.presentation.screen.profile_edit.ProfileEditScreen
import com.coder.siakad.presentation.screen.schedule.ScheduleScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiakadApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    // For this week, because we haven't install Navigation, just put your Screen in this
    // if you wanted to test your screen in emulator

    // ex :
//   DashboardScreen()
//    ProfileScreen(title = "Profile", navigateBack = {}, modifier = Modifier)
//     ScheduleScreen()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        modifier = modifier,
        bottomBar = {
            if (
                currentRoute == Screen.Dashboard.route
                || currentRoute == Screen.Profile.route
                || currentRoute == Screen.Schedule.route
                || currentRoute == Screen.Attendance.route
                || currentRoute == Screen.AcademicFees.route
                || currentRoute == Screen.KRS.route
            ) {
                NavBar(navController)
            }
        }
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            modifier = Modifier.padding(contentPadding)
        ) {
            composable(route = Screen.Login.route) {
//                val loginViewModel: LoginViewModel = hiltViewModel()
                LoginScreen(navigateToDashboard = {
                    navController.navigate(route = Screen.Dashboard.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                })
            }
            composable(route = Screen.Dashboard.route) {
                DashboardScreen(
                    onLogout = { navController.navigateUp() },
                    menuButtonHandler = listOf(
                        { navController.navigate(Screen.Schedule.route) },
                        { navController.navigate(Screen.Attendance.route) },
                        { navController.navigate(Screen.KRS.route) },
                        { navController.navigate(Screen.AcademicFees.route) },
                        {}
                    ),
                    navigateToProfile = { navController.navigate(Screen.Profile.route) }
                )
            }
            composable(Screen.Schedule.route) {
                ScheduleScreen(navigateBack = {
                    navController.navigateUp()
                })
            }
            composable(Screen.Attendance.route) {
                AttendanceScreen(navigateToPresensiForm = { navController.navigate(Screen.FormPresensi.route) },
                    navigateBack = {
                        navController.navigateUp()
                    })
            }
            composable(Screen.FormPresensi.route) {
                PresensiFormScreen(
                    navigateBack = {
                        navController.navigateUp()
                    },
                    labelSchedule = "Pemrograman Web",
                    onClick = {}
                )
            }
            composable(Screen.AcademicFees.route) {
                AcademicFeesScreen(navigateBack = {
                    navController.navigateUp()
                })
            }
            composable(Screen.Profile.route) {
                ProfileScreen(
                    navigateBack = {
                        navController.navigateUp()
                    },
                    navigateToEditProfile = { navController.navigate(Screen.EditProfile.route) }
                )
            }
            composable(Screen.EditProfile.route) {
                ProfileEditScreen(
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
            composable(Screen.KRS.route) {
                KrsScreen(title = "KRS", navigateBack = {
                    navController.navigateUp()
                })
            }
            composable(Screen.Maintenance.route) {
                MaintenanceScreen()
            }
        }
    }
}