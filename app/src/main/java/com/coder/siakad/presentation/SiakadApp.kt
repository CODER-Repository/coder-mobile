package com.coder.siakad.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.coder.siakad.presentation.screen.presensi.Test
import com.coder.siakad.presentation.screen.profile.ProfileScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiakadApp() {
    // For this week, because we haven't install Navigation, just put your Screen in this
    // if you wanted to test your screen in emulator

    // ex :
//   DashboardScreen()
//    ProfileScreen(title = "Profile", navigateBack = {}, modifier = Modifier)
//     ScheduleScreen()
    Test()
}