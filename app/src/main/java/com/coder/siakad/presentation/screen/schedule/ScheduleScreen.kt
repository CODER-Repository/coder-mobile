package com.coder.siakad.presentation.screen.schedule

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.coder.siakad.R
import com.coder.siakad.data.source.remote.network.response.schedule.ScheduleData
import com.coder.siakad.data.source.remote.network.response.schedule.ScheduleResponse
import com.coder.siakad.data.util.Resource
import com.coder.siakad.presentation.component.header.TopBar
import com.coder.siakad.presentation.screen.schedule.components.DayItem
import com.coder.siakad.presentation.screen.schedule.utils.ScheduleColor
import com.coder.siakad.ui.theme.SiakadTheme

/*TODO: change dummy Schedule*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleScreen(
    scheduleViewModel: ScheduleViewModel = hiltViewModel()
) {
    var schedule: ScheduleResponse? by remember { mutableStateOf(null) }
    var isLoading by rememberSaveable { mutableStateOf<Boolean>(false) }

    val context = LocalContext.current

    scheduleViewModel.uiScheduleState.collectAsStateWithLifecycle().value.let { uiState ->
        when (uiState) {
            is Resource.Loading -> {
                isLoading = true
            }

            is Resource.Success -> {
                schedule = uiState.data
                isLoading = false
            }

            is Resource.Error -> {
                Toast.makeText(context, uiState.message, Toast.LENGTH_SHORT).show()
                isLoading = false
            }
        }
    }

    Scaffold(
        topBar = {
            TopBar(
                title = stringResource(id = R.string.schedule)
            )
        }
    ) { paddingValues ->
        schedule?.let { ScheduleContent(it, modifier = Modifier.padding(paddingValues)) }
    }
}

/*
@Composable
fun ScheduleContent(schedules: List<Schedule>, modifier: Modifier) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier.padding(20.dp)
    ) {
        itemsIndexed(items = schedules, key = {_, schedule -> schedule.day }) { index, schedule ->
            DayItem(
                dayName = schedule.day,
                listCourse = schedule.listCourse,
                colorPrimary = ScheduleColor.getByIndex(index).colorPrimary,
                colorOnPrimary = ScheduleColor.getByIndex(index).colorOnPrimary
            )
        }
    }
}
 */

@Composable
fun ScheduleContent(
    schedules: ScheduleResponse,
    modifier: Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier.padding(20.dp)
    ) {
        itemsIndexed(
            items = schedules.data.monday + schedules.data.tuesday + schedules.data.wednesday + schedules.data.thursday + schedules.data.friday,
            key = { _, schedule -> schedules.data }) { index, schedule ->
            DayItem(
                dayName = getDayName(index),
                listCourse = listOf(schedule),
                colorPrimary = ScheduleColor.getByIndex(index).colorPrimary,
                colorOnPrimary = ScheduleColor.getByIndex(index).colorOnPrimary
            )
        }
    }
}

fun getDayName(index: Int): String {
    return when(index){
        0 -> "Monday"
        1 -> "Tuesday"
        2 -> "Wednesday"
        3 -> "Thursday"
        4 -> "Friday"
        5 -> "Saturday"
        7 -> "Sunday"
        else -> "Unkown"
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SchedulePrev() {
    SiakadTheme {
        ScheduleScreen()
    }
}

/*
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
*/