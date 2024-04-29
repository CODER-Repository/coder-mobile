package com.coder.siakad.presentation.screen.attendance

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coder.siakad.presentation.component.header.NavTabRow
import com.coder.siakad.presentation.component.header.TopBar
import com.coder.siakad.presentation.screen.attendance.component.LectureItem
import com.coder.siakad.presentation.screen.schedule.utils.ScheduleColor
import com.coder.siakad.ui.theme.SiakadTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun AttendanceScreen(
    navigateToPresensiForm: () -> Unit,
) {
    val attendanceTitles = listOf("Hari Ini", "Daftar Kelas")
    val tabPagerState = rememberPagerState { attendanceTitles.size }
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopBar(title = "Presensi")
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState())
                .padding(contentPadding)
        ) {
            NavTabRow(
                tabTitles = attendanceTitles,
                pagerState = tabPagerState,
                onChangeTabIndex = { newIndex: Int ->
                    coroutineScope.launch {
                        tabPagerState.animateScrollToPage(newIndex)
                    }
                },
                modifier = Modifier.padding(top = 16.dp, start = 24.dp, bottom = 24.dp, end = 24.dp)
            )
            HorizontalPager(state = tabPagerState) { tabIndex ->
                when (attendanceTitles[tabIndex]) {
                    "Hari Ini" -> {
                        TodayContent(dummyListLecture, modifier = Modifier.padding(20.dp), onClick = navigateToPresensiForm)
                    }
                }
            }
        }
    }
}

@Composable
fun TodayContent(lectures: List<Lecture>, modifier: Modifier = Modifier, onClick:() -> Unit) {
    Card(
        shape = CardDefaults.elevatedShape,
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = modifier
    ) {
        Column {
            Text(
                text = "Pertemuan hari ini", style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.SemiBold
                ), modifier = Modifier.padding(16.dp)
            )
            Divider()
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 28.dp)
            ) {
                lectures.forEachIndexed { index, lecture ->
                    LectureItem(
                        name = lecture.name,
                        color = ScheduleColor.getByIndex(index).colorOnPrimary,
                        numMeet = lecture.numMeet,
                        time = lecture.time,
                        lecturer = lecture.lecturer,
                        onClick = onClick,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun Attendprev() {
    SiakadTheme {
        TodayContent(dummyListLecture, onClick = {})
    }
}

data class Lecture(
    val name: String,
    val numMeet: Int,
    val time: String,
    val lecturer: String
)

val dummyListLecture = listOf(
    Lecture("Mobile App Development", 10, "10:00 - 12:00", "Dr. Smith"),
    Lecture("Web Development", 8, "02:30 - 04:30", "Prof. Johnson"),
    Lecture("Database Management", 12, "01:15 - 03:15", "Dr. Brown"),
    Lecture("Algorithms", 9, "11:45 - 01:45", "Prof. Davis")
)