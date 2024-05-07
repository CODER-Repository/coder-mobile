package com.coder.siakad.presentation.screen.schedule.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coder.siakad.data.source.remote.network.response.schedule.DayItem
import com.coder.siakad.ui.theme.SiakadTheme

/*TODO: change dummy Course*/
@Composable
fun DayItem(
    dayName: String,
    listCourse: List<DayItem>,
    colorPrimary: Color,
    colorOnPrimary: Color,
    modifier: Modifier = Modifier
) {
    Card(
        shape = CardDefaults.outlinedShape,
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = modifier
    ) {
        Text(
            text = dayName,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold, color = colorOnPrimary),
            modifier = Modifier
                .fillMaxWidth()
                .background(colorPrimary)
                .padding(vertical = 10.dp, horizontal = 20.dp)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.padding(top = 12.dp, start = 20.dp, bottom = 32.dp)
        ) {
            listCourse.forEach() {
                CourseItem(
                    name = it.courseName,
                    idClass = it.courseId,
                    time = "${it.timeStart} - ${it.timeEnd}",
                    room = it.courseRoom
                )
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun DayItemPrev() {
    SiakadTheme {
        DayItem(
            dayName = "Monday",
            listCourse = dummySchedules[0].listCourse,
            colorPrimary = Color.Cyan,
            colorOnPrimary = Color.Green
        )
    }
}
 */
