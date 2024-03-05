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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coder.siakad.presentation.component.header.TopBar
import com.coder.siakad.presentation.component.input.SiakadInputText
import com.coder.siakad.presentation.screen.profile.component.ProfileCard
import com.coder.siakad.ui.theme.SiakadTheme

@ExperimentalMaterial3Api
@Composable
fun ProfileEditScreen(
    modifier: Modifier = Modifier,
    title: String,
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
                title = title,
                navigateBack = navigateBack,
                modifier = modifier,
                backButton = true
            )
        },
    ) { paddingValues ->
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
                    .padding(top = 16.dp)
                    .padding(vertical = 24.dp, horizontal = 16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                SiakadInputText(icon = Icons.Outlined.Person, label = "Name", value = username, onValueChange = { username = it })
                SiakadInputText(icon = Icons.Outlined.Email, label = "Email", value = email, onValueChange = { email = it })
                SiakadInputText(icon = Icons.Outlined.Lock, label = "Password", value = password, onValueChange =  { password = it })
                SiakadInputText(icon = Icons.Outlined.Phone, label = "Phone Number", value = phoneNumber, onValueChange =  { phoneNumber = it })
                SiakadInputText(icon = Icons.Outlined.Home, label = "Birthplace", value = birthplace, onValueChange = { birthplace = it })
                SiakadInputText(icon = Icons.Outlined.Home, label = "Date of Birth", value = dateOfBirth, onValueChange = { dateOfBirth = it })
                SiakadInputText(icon = Icons.Outlined.Home, label = "Address", value = address, onValueChange = { address = it })

                Spacer(modifier = Modifier.height(16.dp))
                // Tombol "Batal" dan "Simpan"
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = { /* Handle Batal */ },
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Blue),
                        modifier = Modifier.clip(RoundedCornerShape(8.dp))
                    ) {
                        Text("Batal", color = Color.Blue)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = { /* Handle Simpan */ },
                        colors = ButtonDefaults.buttonColors(contentColor = Color.Blue),
                        modifier = Modifier.clip(RoundedCornerShape(90.dp))
                    ) {
                        Text("Simpan", color = Color.White)
                    }
                }
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
            title = "Edit Profile",
        )
    }
}