package com.coder.siakad.presentation.screen.presensi

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coder.siakad.R
import com.coder.siakad.presentation.component.MultipleChoice
import com.coder.siakad.presentation.component.header.TopBar
import com.coder.siakad.presentation.component.input.SiakadInputText
import com.coder.siakad.ui.theme.SiakadTheme
import com.coder.siakad.ui.theme.TextDisable

@ExperimentalMaterial3Api
@Composable
fun PresensiFormScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
    labelSchedule: String,
    countOfMeeting: Int = 7
) {
    val bottomPadding = 15.dp
    var selectedOption by remember { mutableStateOf(options[0]) }
    var selectedQualityCourse by remember {
        mutableStateOf(optionsQualityCourse[0])
    }

    Scaffold(
        topBar = {
            TopBar(
                title = stringResource(id = R.string.form_presensi)
            )
        }
    ) { paddingValues ->
        Card(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(rememberScrollState()),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.outline)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Column(modifier) {
                    Text(
                        text = stringResource(id = R.string.fill_presensi),
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold)
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text(
                            text = labelSchedule,
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                            color = TextDisable
                        )
                        Text(
                            text = "|",
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                            color = TextDisable
                        )
                        Text(
                            text = stringResource(id = R.string.count_of_meeting, countOfMeeting),
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                            color = TextDisable
                        )
                    }
                }
                Divider()
                SiakadInputText(
                    value = "Pemrograman web",
                    label = stringResource(id = R.string.course),
                    enable = false,
                    supportingText = null
                )
                SiakadInputText(
                    value = "6",
                    label = stringResource(id = R.string.count_of_meeting_form),
                    enable = false,
                    supportingText = null
                )
                MultipleChoice(options = options , selectedOption = "offline"){
                    newSelectedOption ->
                    selectedOption = newSelectedOption
                }
                SiakadInputText(
                    value = "Variable & Tipe data",
                    label = stringResource(id = R.string.meeting_topic),
                    enable = true,
                    required = true,
                    supportingText = null,
                    maxLines = 2
                )
                SiakadInputText(
                    value = "0ffxd",
                    label = stringResource(id = R.string.code_presence),
                    enable = true,
                    required = true,
                    supportingText = null,
                    maxLines = 1
                )
                SiakadInputText(
                    value = "",
                    label = stringResource(id = R.string.summary_of_meeting),
                    enable = true,
                    required = true,
                    supportingText = null,
                    maxLines = 7,
                    placeholder = "\n\n\n\n"
                )
                Text(text = "How quality of the course today's")
                MultipleChoice(options = optionsQualityCourse , selectedOption = "Baik sekali"){
                    newSelectedOption ->
                    selectedQualityCourse = newSelectedOption
                }
                SiakadInputText(
                    value = "",
                    label = stringResource(id = R.string.criticism_suggestions),
                    enable = true,
                    required = true,
                    supportingText = null,
                    maxLines = 7,
                    placeholder = "\n\n\n\n"
                )
            }
        }
    }
}

//Data Dummy
val options = listOf("Luring [Offline]", "Daring [Online]")
val optionsQualityCourse = listOf("Baik sekali", "Baik", "Kurang", "Kurang sekali")


@ExperimentalMaterial3Api
@Preview
@Composable
fun PresensiFormScreenPreview() {
    SiakadTheme {
        PresensiFormScreen(navigateBack = { }, labelSchedule = "Pemrograman Web")
    }
}