package com.coder.siakad.presentation.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarViewMonth
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.coder.siakad.R
import com.coder.siakad.presentation.navigation.Screen
import com.coder.siakad.presentation.screen.overview.CardTodaySchedule
import com.coder.siakad.presentation.screen.overview.dummyListCardLecture
import com.coder.siakad.ui.theme.PrimaryBlue500
import com.coder.siakad.ui.theme.SiakadTheme

@Composable
fun BottomBar(
    navigationItems: List<NavBarItemData>,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    NavigationBar(
        modifier = Modifier
            .shadow(
                elevation = 25.dp,
                spotColor = MaterialTheme.colorScheme.primary,
                ambientColor = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
            ),
        contentColor = Color.Transparent,
        containerColor = Color.White
    ) {
        navigationItems.map { item ->
            NavigationBarItem(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Transparent),
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        if (item.screen.route == Screen.Dashboard.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        } else {
                            popUpTo(Screen.Dashboard.route) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                },
                label = {
                    Text(
                        text = item.label,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        modifier = Modifier.size(28.dp)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.primary.copy(0.3f),
                    unselectedTextColor = MaterialTheme.colorScheme.primary.copy(0.3f)
                ),
            )
        }

    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun NavBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Box(contentAlignment = Alignment.BottomCenter) {
        Row(
            modifier = Modifier,
//                .background(Color.White)
//                .padding(top = 8.dp)
//                .height(80.dp)
//                .fillMaxWidth()
//                .background(Color.White)
        ) {
            val items = listOf<NavBarItemData>(
                NavBarItemData(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_dashboard),
                    label = "Beranda",
//                    selected = true,
                    screen = Screen.Dashboard
                ),
                NavBarItemData(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_task),
                    label = "Tugas",
//                    selected = false,
                    screen = Screen.Maintenance
                ),
                NavBarItemData(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_notification),
                    label = "Notifikasi",
//                    selected = false,
                    screen = Screen.Maintenance
                ),
                NavBarItemData(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_profile),
                    label = "Profil",
//                    selected = false,
                    screen = Screen.Profile
                )
            )
            BottomBar(
                navigationItems = items,
                navController = navController,
                modifier = modifier
            )

//            items.forEachIndexed { index, item ->
//                if (index == items.size / 2) {
//                    Spacer(modifier = Modifier.weight(1f))
//                }
//                NavBarItem(
//                    icon = item.icon,
//                    label = item.label,
//                    selected = currentRoute == item.screen.route,
////                    onClick = item.screen
//                    onClick = {}
//                )
//            }

        }
        Spacer(modifier = Modifier.width(5.dp))
        val sheetState = androidx.compose.material3.rememberModalBottomSheetState()
        var isSheetOpen by rememberSaveable {
            mutableStateOf(false)
        }
        NavBarCenterButton(
            icon = ImageVector.vectorResource(id = R.drawable.ic_overview),
            label = "Overview",
            onClick = { isSheetOpen = true },
        )
        if (isSheetOpen) {
            ModalBottomSheet(
                onDismissRequest = { isSheetOpen = false },
                sheetState = sheetState,
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ) {
               CardTodaySchedule(cardLecture = dummyListCardLecture, name = "Fika", navigateToSchedule = {})
            }
        }
    }
}

data class NavBarItemData(
    val icon: ImageVector,
    val label: String,
//    val selected: Boolean,
    val color: Color = PrimaryBlue500,
    val screen: Screen
//    val onClick: () -> Unit,
)

/*
@Composable
fun RowScope.NavBarItem(
    icon: ImageVector,
//    icon: @Composable () -> Unit,
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
) {
    Box(
        modifier = modifier.weight(1f),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .clickable { onClick() }
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = if (selected) color else color.copy(0.3f),
                modifier = Modifier.size(28.dp)
            )
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = if (selected) color else color.copy(0.3f),
                fontWeight = FontWeight.Medium,
            )
        }
    }
}
*/
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun NavBarCenterButton(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit,
) {
    Box(
        Modifier
            .offset(y = (-20).dp)
            .clip(CircleShape)
            .background(Color.White)
            .padding(8.dp)
    ) {
        Card(
            shape = CircleShape,
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
            onClick = { onClick() },
        ) {
            Column(
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    modifier = Modifier.size(36.dp),
                )
                Text(
                    text = label,
                    style = MaterialTheme.typography.labelSmall,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
        }
    }
}

@Preview
@Composable
fun NavBarCenterButtonPreview() {
    SiakadTheme {
        NavBarCenterButton(
            icon = Icons.Rounded.CalendarViewMonth,
            label = "Overview",
            onClick = {},
        )
    }
}