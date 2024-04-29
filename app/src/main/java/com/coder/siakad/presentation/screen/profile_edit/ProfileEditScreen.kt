package com.coder.siakad.presentation.screen.profile_edit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coder.siakad.R
import com.coder.siakad.presentation.component.CustomButton
import com.coder.siakad.presentation.component.header.TopBar
import com.coder.siakad.presentation.component.input.SiakadInputText
import com.coder.siakad.presentation.screen.profile.component.ProfileCard
import com.coder.siakad.ui.theme.SiakadTheme

@ExperimentalMaterial3Api
@Composable
fun ProfileEditScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var birthplace by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    // Mendefinisikan tampilan EditProfileScreen
    Scaffold(
        topBar = {
            TopBar(
                title = "Edit Proile",
                navigateBack = navigateBack,
                modifier = modifier,
                backButton = true
            )
        },
    ) { paddingValues ->
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
                    .padding(top = 4.dp)
                    .padding(vertical = 16.dp, horizontal = 16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                SiakadInputText(
                    //Before
//                    icon = Icons.Outlined.Person,
                    icon = ImageVector.vectorResource(id = R.drawable.ic_name),
                    label = "Name",
//                    value = username,
                    value = "Rafika Wardah Kamilah",
                    enable = false,
                    supportingText = null
                )
                SiakadInputText(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_email),
                    label = "Email",
//                    value = email,
                    value = "rafika.wardah12@gmail.com",
                    enable = false,
                    supportingText = null,
                )
                SiakadInputText(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_password),
                    label = "Password",
//                    value = password,
                    value = "12345678",
                    isObsecure = true,
                    supportingText = null,
                    onValueChange = { password = it })
                SiakadInputText(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_phone_number),
                    label = "Phone Number",
//                    value = phoneNumber,
                    value = "08561111",
                    supportingText = null,
                    onValueChange = { phoneNumber = it })
                SiakadInputText(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_birth_place),
                    label = "Birthplace",
//                    value = birthplace,
                    value = "Mojokerto",
                    supportingText = null,
                    enable = false
                )
                SiakadInputText(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_date_of_birth),
                    label = "Date of Birth",
//                    value = dateOfBirth,
                    value = "7 Maret 2002",
                    supportingText = null,
                    enable = false
                )
                SiakadInputText(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_address),
                    label = "Address",
//                    value = address,
                    value = "Jl Wachid Hasyim RT/RW 05/12, kecamatan. Mojosari,kabupaten.Mojokerto",
                    supportingText = null,
                    onValueChange = { address = it })

                Spacer(modifier = Modifier.height(16.dp))
                // Tombol "Batal" dan "Simpan"
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.Bottom

                ) {
//                    Button(
//                        onClick = { /* Handle Batal */ },
//                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Blue),
//                        modifier = Modifier.clip(RoundedCornerShape(8.dp))
//                    ) {
//                        Text("Batal", color = Color.Blue)
//                    }
//                    Spacer(modifier = Modifier.width(8.dp))
//                    Button(
//                        onClick = { /* Handle Simpan */ },
//                        colors = ButtonDefaults.buttonColors(contentColor = Color.Blue),
//                        modifier = Modifier.clip(RoundedCornerShape(90.dp))
//                    ) {
//                        Text("Simpan", color = Color.White)
//                    }
                    CustomButton(
                        text = {
                            Text(
                                text = "Batal",
                                style = MaterialTheme.typography.labelLarge.copy(fontStyle = FontStyle.Italic)
                            )
                        },
                        onClick = { /*TODO*/ },
                        varSizeButton = "isWide",
                        varOutline = "isOutline"
                    )
                    Spacer(modifier = Modifier.width(24.dp))
                    CustomButton(
                        text = {
                            Text(
                                text = "Simpan",
                                style = MaterialTheme.typography.labelLarge.copy(fontStyle = FontStyle.Italic)
                            )
                        },
                        onClick = { /*TODO*/ },
                        varSizeButton = "isWide",
                        varOutline = ""
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun ProfileEditScreenPreview() {
    SiakadTheme {
        ProfileEditScreen(
            navigateBack = {},
            modifier = Modifier,
        )
    }
}