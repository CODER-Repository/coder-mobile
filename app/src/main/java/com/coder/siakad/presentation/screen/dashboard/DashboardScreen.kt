package com.coder.siakad.presentation.screen.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.automirrored.outlined.InsertDriveFile
import androidx.compose.material.icons.filled.FormatListNumbered
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.outlined.FormatListNumbered
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.EditCalendar
import androidx.compose.material.icons.rounded.FileCopy
import androidx.compose.material.icons.rounded.RequestQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coder.siakad.presentation.component.NavBar
import com.coder.siakad.presentation.component.header.TopBarIconButton
import com.coder.siakad.presentation.screen.dashboard.component.DashboardMenu
import com.coder.siakad.presentation.screen.dashboard.component.DashboardMenuButton
import com.coder.siakad.presentation.screen.dashboard.component.InformationCard
import com.coder.siakad.presentation.screen.dashboard.component.InformationCardData
import com.coder.siakad.ui.theme.Green500
import com.coder.siakad.ui.theme.PrimaryBlue500
import com.coder.siakad.ui.theme.PrimaryYellow500


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {

    var dropdownExpanded by remember { mutableStateOf(false) }

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
                        TopBarIconButton(onClick = { dropdownExpanded = !dropdownExpanded }) {
                            Icon(
                                imageVector = Icons.Default.MoreHoriz,
                                contentDescription = "notification",
                            )
                        }
                        DropdownMenu(
                            expanded = dropdownExpanded,
                            onDismissRequest = { dropdownExpanded = !dropdownExpanded },
                            offset = DpOffset(12.dp, 8.dp),
                            modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer)
                        ) {
                            Column(
                                modifier = Modifier
                                    .width(IntrinsicSize.Min)
                                    .padding(horizontal = 6.dp),
                                verticalArrangement = Arrangement.spacedBy(6.dp),
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    modifier = Modifier
                                        .clip(MaterialTheme.shapes.extraSmall)
                                        .clickable { }
                                        .padding(4.dp)
                                        .fillMaxWidth(),
                                ) {
                                    Icon(
                                        imageVector = Icons.Outlined.Person,
                                        contentDescription = null,
                                        modifier = Modifier.size(28.dp)
                                    )
                                    Column {
                                        Text(
                                            text = "Profil",
                                            style = MaterialTheme.typography.labelSmall,
                                        )
                                        Text(
                                            text = "Lihat Profil",
                                            style = MaterialTheme.typography.labelSmall,
                                        )
                                    }

                                }
                                Divider()
                                Card(
                                    modifier = Modifier.clickable { },
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.errorContainer,
                                        contentColor = MaterialTheme.colorScheme.error,
                                    ),
                                    shape = MaterialTheme.shapes.extraSmall,
                                ) {
                                    Row(
                                        modifier = Modifier.padding(
                                            vertical = 8.dp,
                                            horizontal = 36.dp
                                        ),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Center,
                                    ) {
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Filled.Logout,
                                            contentDescription = null,
                                            modifier = Modifier.size(18.dp)
                                        )
                                        Text(
                                            text = "Logout",
                                            style = MaterialTheme.typography.labelSmall,
                                            fontWeight = FontWeight.Medium,
                                        )
                                    }
                                }
                            }
                        }
                    }
                )
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.height(IntrinsicSize.Min),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // TODO: Change this box to AsyncImage
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
        },
        bottomBar = { NavBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Dashboard Info
            InformationCard(
                infoItemTopLeft =
                InformationCardData(
                    title = "IPK Kumulatif",
                    icon = Icons.AutoMirrored.Outlined.InsertDriveFile,
                    value = "3.90",
                    color = Green500,
                ),
                infoItemTopRight =
                InformationCardData(
                    title = "Total SKS Diambil",
                    icon = Icons.Default.FormatListNumbered,
                    value = "24",
                    color = PrimaryYellow500,
                ),
                infoItemBottomLeft =
                InformationCardData(
                    title = "Semester",
                    icon = Icons.Outlined.School,
                    value = "2",
                    color = MaterialTheme.colorScheme.primary
                ),
                infoItemBottomRight =
                InformationCardData(
                    title = "Tagihan Terkini",
                    icon = Icons.Default.Payments,
                    color = MaterialTheme.colorScheme.error,
                    value = "Rp.8.500.000",
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Menus
            val menus = listOf(
                DashboardMenu(
                    title = "Jadwal",
                    icon = Icons.Rounded.CalendarMonth,
                    color = Color(0xFFBB50EE),
                    route = "",
                ),
                DashboardMenu(
                    title = "Presensi",
                    icon = Icons.Rounded.EditCalendar,
                    color = Color(0xFF1EB193),
                    route = "",
                ),
                DashboardMenu(
                    title = "Nilai",
                    icon = Icons.Rounded.FileCopy,
                    color = PrimaryYellow500,
                    route = "",
                ),
                DashboardMenu(
                    title = "Biaya Akademik",
                    icon = Icons.Rounded.RequestQuote,
                    color = PrimaryYellow500,
                    route = "",
                ),
                DashboardMenu(
                    title = "Kuisioner",
                    icon = Icons.Outlined.FormatListNumbered,
                    color = PrimaryBlue500,
                    route = "",
                ),
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                userScrollEnabled = false,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                items(menus) { menu ->
                    DashboardMenuButton(
                        title = menu.title,
                        icon = menu.icon,
                        color = menu.color,
                        onClick = {},
                    )
                }
            }
        }
    }
}
