package com.coder.siakad.presentation.screen.attendance.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coder.siakad.R
import com.coder.siakad.presentation.component.CustomButton
import com.coder.siakad.presentation.screen.attendance.utils.lectureName
import com.coder.siakad.ui.theme.SiakadTheme
import com.coder.siakad.ui.theme.TextSecondary

@Composable
fun LectureItem(
    name: String,
    color: Color,
    numMeet: Int,
    time: String,
    lecturer: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = CardDefaults.elevatedShape,
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = modifier
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(
                            color
                        )
                ) {
                    Text(
                        text = name.lectureName(),
                        style = MaterialTheme.typography.labelMedium.copy(
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontStyle = FontStyle.Italic
                        ),
                        overflow = TextOverflow.Clip,
                        maxLines = 1
                    )
                }
                Text(
                    text = name,
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
            Divider()
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 16.dp, top = 12.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.CalendarMonth,
                    contentDescription = "meeting",
                    tint = TextSecondary
                )
                Text(
                    text = "Pertemuan ke-$numMeet",
                    style = MaterialTheme.typography.labelMedium.copy(
                        color = TextSecondary
                    )
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 16.dp, top = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Schedule,
                    contentDescription = "time",
                    tint = TextSecondary
                )
                Text(
                    text = time, style = MaterialTheme.typography.labelMedium.copy(
                        color = TextSecondary
                    )
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 20.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "lecturer",
                    tint = TextSecondary
                )
                Text(
                    text = lecturer,
                    style = MaterialTheme.typography.labelMedium.copy(
                        color = TextSecondary
                    )
                )
            }
            CustomButton(
                modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
                varSizeButton = "isWide",
                varOutline = "",
                text = {
                    Text(text = "Selengkapnya", style = MaterialTheme.typography.labelMedium)
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_detail_lecture),
                        contentDescription = "detail",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(start = 8.dp)
                    )
                },
                onClick = onClick,
            )
        }
    }
}

@Preview
@Composable
fun LecturePrev() {
    SiakadTheme {
        LectureItem(
            name = "Desain Pengalaman Pengguna",
            color = MaterialTheme.colorScheme.primary,
            numMeet = 6,
            time = "07:30 - 09:10",
            lecturer = "Arip Budiono S.ST., M.T",
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
        )
    }
}