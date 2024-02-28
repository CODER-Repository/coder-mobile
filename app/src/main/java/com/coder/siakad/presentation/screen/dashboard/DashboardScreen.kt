package com.coder.siakad.presentation.screen.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.InsertDriveFile
import androidx.compose.material.icons.filled.FormatListNumbered
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.School
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coder.siakad.presentation.component.TopBarIconButton
import com.coder.siakad.presentation.screen.dashboard.component.DashboardInfo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {
    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(horizontal = 18.dp)
                    .padding(bottom = 24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults
                        .centerAlignedTopAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primary,
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
                                imageVector = Icons.Default.MoreHoriz,
                                contentDescription = "notification",
                            )
                        }
                    }
                )
                Column(modifier = Modifier.fillMaxWidth()) {
                    // TODO: Change this box to AsyncImage
                    Row(
                        modifier = Modifier.height(IntrinsicSize.Min),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(72.dp)
                                .border(4.dp, Color.White, CircleShape)
                                .clip(CircleShape)
                                .background(Color.LightGray)
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            Column {
                                Text(
                                    text = "Husni Mubarok",
                                    style = MaterialTheme.typography.labelLarge,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = "Informatika",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                            Card(shape = MaterialTheme.shapes.small) {
                                Text(
                                    text = "Reguler",
                                    fontWeight = FontWeight.Medium,
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            OutlinedCard {
                Column(
                    modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Row(Modifier.height(IntrinsicSize.Min)) {
                            DashboardInfo(
                                title = "IPK Kumulatif",
                                icon = Icons.AutoMirrored.Outlined.InsertDriveFile,
                                value = "3.90",
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
                            DashboardInfo(
                                title = "Total SKS Diambil",
                                icon = Icons.Default.FormatListNumbered,
                                value = "24",
                                color = Color(0xFFEDA60E),
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                    OutlinedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Row(Modifier.height(IntrinsicSize.Min)) {
                            DashboardInfo(
                                title = "Semester",
                                icon = Icons.Outlined.School,
                                value = "2",
                                modifier = Modifier.weight(1f)
                            )
                            Spacer(
                                modifier = Modifier
                                    .width(1.dp)
                                    .fillMaxHeight()
                                    .padding(vertical = 12.dp)
                                    .background(MaterialTheme.colorScheme.outline)
                            )
                            DashboardInfo(
                                title = "Tagihan Terkini",
                                icon = Icons.Default.Payments,
                                color = MaterialTheme.colorScheme.error,
                                value = "Rp.8.500.000",
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        }
    }
}
