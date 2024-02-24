package com.coder.siakad.presentation.component.header

import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Rule
import androidx.compose.material.icons.filled.PermIdentity
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.coder.siakad.R
import com.coder.siakad.presentation.component.input.SiakadInputText
import com.coder.siakad.ui.theme.PlaceholderPrimary
import com.coder.siakad.ui.theme.PrimaryBackground
import com.coder.siakad.ui.theme.PrimaryBlue500
import com.coder.siakad.ui.theme.TextDisable
import com.coder.siakad.ui.theme.TextSecondary
import com.coder.siakad.ui.theme.Typography

@ExperimentalMaterial3Api
@Composable
fun ProfileHeader(
    modifier: Modifier = Modifier,
    username: String,
    iconUrl: String,
    nim: String,
    email: String,
    title: String,
    phoneNumber: String,
    entryYear: String,
    navigateBack: () -> Unit,
    topPadding: Dp = 20.dp,
    ) {
    Scaffold(
        topBar = {
            Row(modifier = modifier) {
                TopBar(title = title, navigateBack = navigateBack, modifier = modifier)
                Icon(
                    imageVector = Icons.AutoMirrored.Default.Rule,
                    contentDescription = stringResource(id = R.string.edit_profile)
                )
            }
        },
    ) { paddingValues ->
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = PrimaryBackground
        ) {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    AsyncImage(
                        modifier = modifier
                            .clip(CircleShape)
                            .size(75.dp),
                        model = iconUrl,
                        contentDescription = stringResource(id = R.string.img_profile),
                        contentScale = ContentScale.Crop,
                    )
                    Text(
                        modifier = modifier,
                        text = username,
                        style = Typography.labelLarge.merge(
                            PrimaryBlue500,
                            fontWeight = FontWeight.SemiBold
                        ),
                    )
                    Text(
                        text = nim,
                        modifier = modifier,
                        style = Typography.labelSmall.merge(TextDisable)
                    )
                }
                Card(modifier = modifier.fillMaxWidth(),) {
                    Column(modifier = modifier.padding(horizontal = 20.dp, vertical = 20.dp)) {
                        Row(modifier = modifier) {
                            Text(text = stringResource(id = R.string.personal_data))
                            Spacer(modifier = Modifier.width(10.dp))
                            Icon(
                                painterResource(id = R.drawable.personal_data),
                                contentDescription = stringResource(
                                    id = R.string.personal_data
                                )
                            )
                        }
                        Spacer(modifier = modifier.height(10.dp))
                        SiakadInputText(
                            icon = Icons.Default.PermIdentity,
                            value = username,
                            label = stringResource(
                                id = R.string.name
                            ),
                            isChange = true
                        )
                        SiakadInputText(
                            icon = Icons.Default.PermIdentity,
                            value = email,
                            label = stringResource(
                                id = R.string.email
                            ),
                            isChange = false
                        )
                        SiakadInputText(
                            icon = Icons.Default.PermIdentity,
                            value = phoneNumber,
                            label = stringResource(
                                id = R.string.phone_number
                            ),
                            isChange = false
                        )
                        SiakadInputText(
                            icon = Icons.Default.PermIdentity,
                            value = entryYear,
                            label = stringResource(
                                id = R.string.entry_year
                            ),
                            isChange = false
                        )
                    }
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun ProfileHeaderPreview() {
    ProfileHeader(
        iconUrl = "https://www.google.com/imgres?imgurl=https%3A%2F%2Fstudio.mrngroup.co%2Fstorage%2Fapp%2Fmedia%2FPrambors%2FEditorial%25203%2FAnime-20230828121723.webp%3Ftr%3Dw-600&tbnid=-Wn87_bwiBZ6YM&vet=12ahUKEwjZq9uezL6EAxX2a2wGHYXUDDAQMygEegQIARBK..i&imgrefurl=https%3A%2F%2Fwww.pramborsfm.com%2Flifestyle%2F45-kosakata-bahasa-jepang-yang-sering-digunakan-di-anime-lengkap-dengan-arti&docid=qvrRwy6z9ZChGM&w=960&h=640&q=anime&ved=2ahUKEwjZq9uezL6EAxX2a2wGHYXUDDAQMygEegQIARBK",
        username = "Rafika Wardah",
        nim = "3012110023",
        navigateBack = {},
        modifier = Modifier,
        title = "Profile",
        email = "rafka.wardah12@gmail.com",
        phoneNumber = "085695410323",
        entryYear = "2021"
    )
}