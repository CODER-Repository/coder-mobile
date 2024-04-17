package com.coder.siakad.presentation.screen.krs

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Article
import androidx.compose.material.icons.automirrored.outlined.InsertDriveFile
import androidx.compose.material.icons.filled.AssignmentInd
import androidx.compose.material.icons.filled.ContactMail
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.FormatListNumbered
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coder.siakad.R
import com.coder.siakad.presentation.component.header.TopBar
import com.coder.siakad.presentation.screen.krs.component.KrsInfo
import com.coder.siakad.presentation.screen.krs.component.KrsNotification
import com.coder.siakad.presentation.screen.krs.component.ToggleButton
import com.coder.siakad.ui.theme.SiakadTheme
import com.coder.siakad.ui.theme.TextDisable

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun KrsScreen(
    modifier: Modifier = Modifier,
    title: String
) {
    // TopBar
    Scaffold(
        topBar = {
            TopBar(
                title = title,
                modifier = modifier
            )
        },
    ) { paddingValues ->
        Surface {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
                    .padding(top = 16.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                Column(
                    modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Column(modifier) {
                        Text(
                            text = stringResource(id = R.string.krs_title),
                            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold)
                        )
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            Text(
                                text = stringResource(id = R.string.profile_mahasiswa),
                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                                color = TextDisable
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(1.dp))

                    // Informasi KRS
                    KrsNotification(
                        info = stringResource(id = R.string.krs_approved),
                        backgroundColor = Color(0xFF1EB193),
                        textColor = Color(0xFF1EB193),
                        rectangleWidth = 10.dp,
                    )

                    Spacer(modifier = Modifier.height(1.dp))
                }
                // KRS Info
                OutlinedCard {
                    Column(
                        modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedCard(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                Modifier.height(IntrinsicSize.Max)
                            ) {
                                KrsInfo(
                                    title = "Nama",
                                    icon = Icons.Default.ContactMail,
                                    value = "Fillah Amanda S",
                                    color = Color(0xFF1EB193),
                                    modifier = Modifier.weight(1f)
                                )
                                Spacer(
                                    modifier = Modifier
                                        .width(1.dp)
                                        .fillMaxHeight()
                                        .padding(vertical = 12.dp)
                                        .background(MaterialTheme.colorScheme.outline)
                                )
                                KrsInfo(
                                    title = "NIM",
                                    icon = Icons.Default.CreditCard,
                                    value = "2141762001",
                                    color = Color(0xFFEDA60E),
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }
                        OutlinedCard(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                Modifier.height(IntrinsicSize.Max)
                            ) {
                                KrsInfo(
                                    title = "Semester",
                                    icon = Icons.Default.School,
                                    value = "6 (2023/2024) Genap",
                                    color = Color(0xFF015C92),
                                    modifier = Modifier.weight(1f)
                                )
                                Spacer(
                                    modifier = Modifier
                                        .width(1.dp)
                                        .fillMaxHeight()
                                        .padding(vertical = 12.dp)
                                        .background(MaterialTheme.colorScheme.outline)
                                )
                                KrsInfo(
                                    title = "Dosen PA/Wali",
                                    icon = Icons.Default.Person,
                                    value = "Fillah Amanda Sulton, S.Kom., M.Kom",
                                    color = Color(0xFFE2504C),
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                ToggleButton()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun KrsScreenPreview() {
    SiakadTheme {
        KrsScreen(
            modifier = Modifier,
            title = "KRS",
        )
    }
}
