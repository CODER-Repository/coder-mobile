package com.coder.siakad.presentation.screen.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coder.siakad.presentation.component.header.TopBarIconButton
import com.coder.siakad.ui.theme.PrimaryBlue500

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier
                    .background(PrimaryBlue500)
                    .padding(horizontal = 8.dp),
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = PrimaryBlue500,
                    titleContentColor = Color.White,
                ),
                title = {
                    Text(
                        text = "Beranda",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 24.sp,
                    )
                },
                navigationIcon = {
                    TopBarIconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "notification",
                        )
                    }
                },
                actions = {
                    TopBarIconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "notification",
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column {

            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .background(Color(0xFF245399))
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .border(4.dp, Color.White, CircleShape)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                )

            }
            Column {
                CardDefaults.cardColors()
                Card {
                    Text(
                        text = "test",
                        modifier = Modifier.padding(24.dp)
                    )
                }
            }
        }
    }
}
