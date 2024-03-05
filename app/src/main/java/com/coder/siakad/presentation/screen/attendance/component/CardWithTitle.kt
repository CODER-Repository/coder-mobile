package com.coder.siakad.presentation.screen.attendance.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coder.siakad.common.helper.TableData
import com.coder.siakad.ui.theme.SiakadTheme

data class CourseData(
    val code: String,
    val name: String,
    val courseClass: String,
)

@Composable
fun CardWithTitle(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Card(
        modifier = modifier
    ) {
        Text(
            text = "Daftar Kelas Yang tersedia",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(18.dp)
        )
        Divider()
        Box(Modifier.padding(18.dp)) {
            content()
        }
    }
}

@Preview
@Composable
private fun CardWithTitlePreview() {
    SiakadTheme {
        val courses = listOf(
            CourseData(
                "code-123",
                "name-123",
                "class-123",
            ),
            CourseData(
                "code-123",
                "name-123",
                "class-123",
            ),
            CourseData(
                "code-123",
                "name-123",
                "class-123",
            ),
            CourseData(
                "code-123",
                "name-123",
                "class-123",
            )
        )

        val tableCourses =
            TableData(courses).createTable { listOf(it.code, it.name, it.courseClass) }


        CardWithTitle {
            Column() {
                tableCourses.forEach { row ->
                    Row() {
                        row.forEach { data ->
                            Text(
                                text = data,
                                modifier = Modifier
                                    .border(1.dp, Color.Black)
                                    .padding(8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

