package com.coder.siakad.presentation.screen.overview

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coder.siakad.presentation.screen.overview.component.CardOverview
import com.coder.siakad.presentation.screen.schedule.utils.ScheduleColor
import com.coder.siakad.ui.theme.SiakadTheme

@Composable
fun CardTodaySchedule(
    cardLecture: List<CardLecture>,
    modifier: Modifier = Modifier,
    name: String,
    navigateToSchedule: () -> Unit
) {
    Column(
        modifier = modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Hi, $name \uD83D\uDC4B",
            style = MaterialTheme.typography.titleLarge.copy(fontStyle = FontStyle.Italic),
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Lihat aktivitas perkuliahanmu hari ini",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Jadwal Kuliah Hari Ini",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold)
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                TextButton(onClick = {  }) {
                    Text(
                        text = "Selengkapnya",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Normal),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = "Selengkapnya"
                )
            }
        }
        LazyRow(
        ) {
            items(dummyListCardLecture) { cardLecture ->
                CardOverview(
                    name = cardLecture.name,
                    grade = cardLecture.grade,
                    title = cardLecture.title,
                    time = cardLecture.time,
                    place = cardLecture.place,
                    status = cardLecture.status,
                    colorLabel = MaterialTheme.colorScheme.primary,
                    colorTitle = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

data class CardLecture(
    val grade: String,
    val name: String,
    val title: String,
    val time: String,
    val place: String,
    val status: String
)

val dummyListCardLecture = listOf(
    CardLecture(
        name = "PW",
        grade = "IF-2B",
        title = "Pemrograman Web",
        time = "07:30 - 09:10",
        place = "LAB - CODE",
        status = "Telah Selesai",
    ),
    CardLecture(
        name = "DPP",
        grade = "IF-2B",
        title = "Design Pengalaman Pengguna",
        time = "09:30 - 11:30",
        place = "CM-303",
        status = "Sedang Berlangsung",
    ),
    CardLecture(
        name = "PW",
        grade = "IF-2B",
        title = "Pemrograman Web",
        time = "07:30 - 09:10",
        place = "LAB - CODE",
        status = "Telah Selesai",
    ),
    CardLecture(
        name = "DPP",
        grade = "IF-2B",
        title = "Design Pengalaman Pengguna",
        time = "09:30 - 11:30",
        place = "CM-303",
        status = "Sedang Berlangsung",
    ),
)

@Preview(showBackground = true)
@Composable
private fun CardTodayContentPreview() {
    SiakadTheme {
        CardTodaySchedule(cardLecture = dummyListCardLecture, name = "Rafika", navigateToSchedule = {})
    }
}