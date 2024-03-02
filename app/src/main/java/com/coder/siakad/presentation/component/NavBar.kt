package com.coder.siakad.presentation.component

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarViewMonth
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coder.siakad.ui.theme.PrimaryBlue500
import com.coder.siakad.ui.theme.SiakadTheme

@Composable
fun NavBar() {
    Box(contentAlignment = Alignment.BottomCenter) {
        Row(
            Modifier
                .background(Color.White)
                .padding(top = 8.dp)
                .height(80.dp)
                .fillMaxWidth()
        ) {
            val items = listOf(
                NavBarItemData(
                    icon = Icons.Rounded.Home,
                    label = "Beranda",
                    selected = true,
                    onClick = {},
                ),
                NavBarItemData(
                    icon = Icons.Rounded.Home,
                    label = "Beranda",
                    selected = false,
                    onClick = {},
                ),
                NavBarItemData(
                    icon = Icons.Rounded.Home,
                    label = "Beranda",
                    selected = false,
                    onClick = {},
                ),
                NavBarItemData(
                    icon = Icons.Rounded.Home,
                    label = "Beranda",
                    selected = false,
                    onClick = {},
                )
            )

            items.forEachIndexed { index, item ->
                if (index == items.size / 2) {
                    Spacer(modifier = Modifier.weight(1f))
                }
                NavBarItem(
                    icon = item.icon,
                    label = item.label,
                    selected = item.selected,
                    onClick = item.onClick
                )
            }
        }
        NavBarCenterButton(
            icon = Icons.Rounded.CalendarViewMonth,
            label = "Overview",
            onClick = {},
        )
    }
}

data class NavBarItemData(
    val icon: ImageVector,
    val label: String,
    val selected: Boolean,
    val color: Color = PrimaryBlue500,
    val onClick: () -> Unit,
)

@Composable
fun RowScope.NavBarItem(
    icon: ImageVector,
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

@OptIn(ExperimentalMaterial3Api::class)
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
fun NavigationBarPreview() {
    SiakadTheme {
        NavBar()
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