package com.coder.siakad.presentation.screen.schedule.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTimeFilled
import androidx.compose.material.icons.filled.Class
import androidx.compose.material.icons.filled.MapsHomeWork
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coder.siakad.ui.theme.SiakadTheme
import com.coder.siakad.ui.theme.TextPrimary
import com.coder.siakad.ui.theme.TextSecondary

@Composable
fun CourseItem(
    name: String,
    idClass: String,
    time: String,
    room: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold, color = TextPrimary),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row {
            Icon(
                imageVector = Icons.Default.Class,
                contentDescription = null,
                modifier = Modifier.padding(end = 10.dp)
            )
            Text(text = idClass, style = MaterialTheme.typography.bodyLarge.copy(color = TextSecondary))
        }
        Row {
            Icon(
                imageVector = Icons.Default.AccessTimeFilled,
                contentDescription = null,
                modifier = Modifier.padding(end = 10.dp)
            )
            Text(text = time, style = MaterialTheme.typography.bodyLarge.copy(color = TextSecondary))
        }
        Row {
            Icon(
                imageVector = Icons.Default.MapsHomeWork,
                contentDescription = null,
                modifier = Modifier.padding(end = 10.dp)
            )
            Text(text = room, style = MaterialTheme.typography.bodyLarge.copy(color = TextSecondary))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoursePrev() {
    SiakadTheme {
        CourseItem(name = "Matematika Diskret 2", idClass = "IF-2B", time = "07:30 - 09:10", room = "CM-202" )
    }
}

