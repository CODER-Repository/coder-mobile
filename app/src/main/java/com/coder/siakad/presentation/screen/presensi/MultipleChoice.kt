package com.coder.siakad.presentation.screen.presensi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MultipleChoice(value: List<String>) {
    val option = value
    var isSelected by remember { mutableStateOf(option[0]) }

    Column {
        option.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .selectable(
                        selected = isSelected == option,
                        onClick = { isSelected = option }
                    )
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = isSelected == option,
                    onClick = { isSelected = option },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = Color.Gray,
                        selectedColor = Color.Blue,
                    )
                )
                Text(
                    text = option,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
        }
    }
}


@Preview
@Composable
fun MultipleChoicePreview(){
    MultipleChoice(
        listOf("Luring [Offline]", "Daring [Online]")
    )
}