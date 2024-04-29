package com.coder.siakad.presentation.screen.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.coder.siakad.R
import com.coder.siakad.presentation.component.header.TopBar
import com.coder.siakad.presentation.component.header.TopBarIconButton
import com.coder.siakad.presentation.screen.profile.component.ProfileCard
import com.coder.siakad.presentation.screen.profile.component.ProfileHeader
import com.coder.siakad.ui.theme.SiakadTheme

@ExperimentalMaterial3Api
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
    navigateToEditProfile: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(
                title = "Profile",
                navigateBack = navigateBack,
                modifier = modifier,
                backButton = true,
                actions = {
                    TopBarIconButton(onClick = { navigateToEditProfile() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_edit_profile),
                            contentDescription = stringResource(id = R.string.edit_profile)
                        )
                    }
                })
        },
    ) { paddingValues ->
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(paddingValues)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                ProfileHeader(
                    username = "Rafika",
                    imageUrl = "iconUrl",
                    nim = "3012110023",
                )
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
        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    SiakadTheme {
        ProfileScreen(
            navigateBack = {},
            modifier = Modifier,
            navigateToEditProfile = {}
        )
    }
}