package com.coder.siakad.presentation.screen.profile.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coder.siakad.R
import com.coder.siakad.presentation.component.input.SiakadInputText
import com.coder.siakad.ui.theme.Green500
import com.coder.siakad.ui.theme.PrimaryBlue150
import com.coder.siakad.ui.theme.PrimaryBlue500

@Composable
fun ProfileCard(
    modifier: Modifier = Modifier,
    username: String,
    email: String,
    phoneNumber: String,
    birthplace: String,
    dateOfBirth: String,
    address: String,
    password: String,
    nim: String,
    studyProgram: String,
    entryYear: String,
    classType: String,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.outline)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            //PERSONAL DATA
            Column(
                modifier = modifier.padding(horizontal = 20.dp, vertical = 20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(id = R.string.personal_data),
                        style = MaterialTheme.typography.labelLarge,
                        color = Green500
                    )
                    Spacer(modifier = modifier.width(10.dp))
                    Box(
                        modifier
                            .background(shape = CircleShape, color = Green500.copy(alpha = 0.2f))
                            .size(30.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painterResource(id = R.drawable.ic_personal_data),
                            contentDescription = stringResource(
                                id = R.string.personal_data
                            )
                        )
                    }
                }
                SiakadInputText(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_name),
                    value = username,
                    label = stringResource(
                        id = R.string.name
                    ),
                    enable = false,
                    supportingText = null
                )
                SiakadInputText(
                    value = email,
                    label = stringResource(
                        id = R.string.email
                    ),
                    enable = false,
                    supportingText = null
                )
                SiakadInputText(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_phone_number),
                    value = phoneNumber,
                    label = stringResource(
                        id = R.string.phone_number
                    ),
                    enable = true,
                    supportingText = null
                )
                SiakadInputText(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_birth_place),
                    value = birthplace,
                    label = stringResource(
                        id = R.string.birthplace
                    ),
                    enable = false,
                    supportingText = null
                )
                SiakadInputText(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_date_of_birth),
                    value = dateOfBirth,
                    label = stringResource(id = R.string.date_of_birth),
                    enable = false,
                    supportingText = null
                )
                SiakadInputText(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_address),
                    value = address,
                    label = stringResource(id = R.string.address),
                    enable = true,
                    supportingText = null
                )
                SiakadInputText(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_password),
                    value = password,
                    label = stringResource(id = R.string.password),
                    enable = true,
                    isObsecure = true,
                    supportingText = null,
                )
//                Spacer(modifier = Modifier.height(10.dp))
            }
            //ACADEMIC DATA
            Divider(modifier = modifier.fillMaxWidth())
            Column(
                modifier = modifier.padding(horizontal = 20.dp, vertical = 20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(id = R.string.academic_data),
                        style = MaterialTheme.typography.labelLarge,
                        color = PrimaryBlue500
                    )
                    Spacer(modifier = modifier.width(10.dp))
                    Box(
                        modifier
                            .background(shape = CircleShape, color = PrimaryBlue150)
                            .size(30.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painterResource(id = R.drawable.ic_academic_data),
                            contentDescription = stringResource(
                                id = R.string.personal_data
                            )
                        )
                    }
                }
                SiakadInputText(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_nim),
                    value = nim,
                    label = stringResource(id = R.string.nim),
                    enable = false,
                    supportingText = null,
                )
                SiakadInputText(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_program_study),
                    value = studyProgram,
                    label = stringResource(id = R.string.study_program),
                    enable = false,
                    supportingText = null,
                )
                SiakadInputText(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_entry_year),
                    value = entryYear,
                    label = stringResource(id = R.string.entry_year),
                    enable = false,
                    supportingText = null,
                )
                SiakadInputText(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_class_type),
                    value = classType,
                    label = stringResource(id = R.string.class_type),
                    enable = false,
                    supportingText = null,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileCardPreview() {
    ProfileCard(
        username = "Rafika Wardah",
        email = "rafika.wardah12@gmail.com",
        phoneNumber = "08561111",
        birthplace = "Mojokerto",
        entryYear = "2021",
        dateOfBirth = "7 Maret 2002",
        address = "Jl Wachid Hasyim RT/RW 05/12, kecamatan. Mojosari,kabupaten.Mojokerto",
        password = "RafikaWardah",
        nim = "3012110023",
        classType = "Reguler",
        studyProgram = "Informatika"
    )
}