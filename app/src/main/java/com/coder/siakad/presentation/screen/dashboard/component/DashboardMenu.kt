package com.coder.siakad.presentation.screen.dashboard.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coder.siakad.R
import com.coder.siakad.ui.theme.SiakadTheme
import com.coder.siakad.ui.theme.TextSecondary

data class DashboardMenu(
    val title: String,
    val icon: ImageVector,
    val color: Color,
    val route: String,
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardMenuButton(
    title: String,
    icon: ImageVector,
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        Card(
            onClick = onClick,
            colors = CardDefaults.cardColors(
                containerColor = color.copy(0.2f),
                contentColor = color,
            ),
        ) {
            Box(
                Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(36.dp)
                )
            }
        }
        Text(
            text = title,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            color = TextSecondary,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun DashboardMenuButtonPreview() {
    SiakadTheme {
        Surface(color = Color.White) {
            DashboardMenuButton(
                title = "Dashboard",
                icon = ImageVector.vectorResource(id = R.drawable.ic_academic_data),
                color = Color.Blue,
                onClick = {}
            )
        }
    }
}