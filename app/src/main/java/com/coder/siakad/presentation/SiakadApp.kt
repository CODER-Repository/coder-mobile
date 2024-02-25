package com.coder.siakad.presentation

import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import com.coder.siakad.presentation.screen.dashboard.DashboardScreen
import com.coder.siakad.presentation.screen.schedule.ScheduleScreen

@Composable
fun SiakadApp() {
    // For this week, because we haven't install Navigation, just put your Screen in this
    // if you wanted to test your screen in emulator

    // ex :
//    DashboardScreen()
    ScheduleScreen()
}