package com.coder.siakad.presentation.screen.schedule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coder.siakad.presentation.screen.schedule.components.DayItem
import com.coder.siakad.presentation.screen.schedule.utils.ScheduleColor
import com.coder.siakad.ui.theme.SiakadTheme

/*TODO: change dummy Schedule*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Jadwal",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge.copy(
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primary),
                navigationIcon = {})
        }
    ) { paddingValues ->
        ScheduleContent(dummySchedules, modifier = Modifier.padding(paddingValues))
    }
}

@Composable
fun ScheduleContent(schedules: List<Schedule>, modifier: Modifier) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier.padding(20.dp)
    ) {
        itemsIndexed(schedules, key = {_, schedule -> schedule.day }) { index, schedule ->
            DayItem(
                dayName = schedule.day,
                listCourse = schedule.listCourse,
                colorPrimary = ScheduleColor.getByIndex(index).colorPrimary,
                colorOnPrimary = ScheduleColor.getByIndex(index).colorOnPrimary
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SchedulePrev() {
    SiakadTheme {
        ScheduleScreen()
    }
}

data class Schedule(
    val day: String,
    val listCourse: List<Course>
)

data class Course(
    val courseName: String,
    val idClass: String,
    val time: String,
    val room: String
)

val dummySchedules = listOf(
    Schedule(
        "Monday", listOf(
            Course("Programming Fundamentals", "TI01", "09:00 AM - 11:00 AM", "Room 101"),
            Course("Database Management", "TI02", "10:00 AM - 12:00 PM", "Room 102"),
            Course("Web Development Lab", "TI03", "01:00 PM - 03:00 PM", "Computer Lab 1A")
        )
    ),
    Schedule(
        "Tuesday", listOf(
            Course("Web Development", "TI03", "09:00 AM - 11:00 AM", "Room 103"),
            Course("Data Structures", "TI04", "10:00 AM - 12:00 PM", "Room 104"),
            Course("Algorithm Design", "TI05", "01:00 PM - 03:00 PM", "Room 105")
        )
    ),
    Schedule(
        "Wednesday", listOf(
            Course("Networking Basics", "TI06", "09:00 AM - 11:00 AM", "Room 106"),
            Course("Software Engineering", "TI07", "10:00 AM - 12:00 PM", "Room 107"),
            Course("Database Management Lab", "TI02", "02:00 PM - 04:00 PM", "Computer Lab 1B")
        )
    ),
    Schedule(
        "Thursday", listOf(
            Course("Mobile App Development", "TI08", "09:00 AM - 11:00 AM", "Room 108"),
            Course("Operating Systems", "TI09", "10:00 AM - 12:00 PM", "Room 109")
        )
    ),
    Schedule(
        "Friday", listOf(
            Course("Computer Networks", "TI10", "09:00 AM - 11:00 AM", "Room 110"),
            Course("Artificial Intelligence", "TI11", "10:00 AM - 12:00 PM", "Room 111"),
            Course("Mobile App Development Lab", "TI08", "01:00 PM - 03:00 PM", "Computer Lab 2A")
        )
    )
)