package com.coder.siakad.presentation.screen.dashboard.component

import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.coder.siakad.ui.theme.TextSecondary


data class InformationCardData(
    val title: String,
    val icon: ImageVector,
    val value: String,
    val color: Color,
)

@Composable
fun InformationCard(
    infoItemTopLeft: InformationCardData,
    infoItemTopRight: InformationCardData,
    infoItemBottomLeft: InformationCardData,
    infoItemBottomRight: InformationCardData,
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
                    InformationCardItem(
                        title = infoItemTopLeft.title,
                        icon = infoItemBottomLeft.icon,
                        value = infoItemTopLeft.value,
                        color = infoItemTopLeft.color,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(
                        modifier = Modifier
                            .width(1.dp)
                            .fillMaxHeight()
                            .padding(vertical = 12.dp)
                            .background(MaterialTheme.colorScheme.outline)
                    )
                    InformationCardItem(
                        title = infoItemTopRight.title,
                        icon = infoItemTopRight.icon,
                        value = infoItemTopRight.value,
                        color = infoItemTopRight.color,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            OutlinedCard(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(Modifier.height(IntrinsicSize.Min)) {
                    InformationCardItem(
                        title = infoItemBottomLeft.title,
                        icon = infoItemBottomLeft.icon,
                        value = infoItemBottomLeft.value,
                        color = infoItemBottomLeft.color,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(
                        modifier = Modifier
                            .width(1.dp)
                            .fillMaxHeight()
                            .padding(vertical = 12.dp)
                            .background(MaterialTheme.colorScheme.outline)
                    )
                    InformationCardItem(
                        title = infoItemBottomRight.title,
                        icon = infoItemBottomRight.icon,
                        color = infoItemBottomRight.color,
                        value = infoItemBottomRight.value,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun InformationCardItem(
    title: String,
    icon: ImageVector,
    value: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
) {
    Row(
        modifier = modifier
            .padding(vertical = 16.dp, horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            Modifier
                .background(color.copy(0.2f), CircleShape)
                .size(32.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = color,
                modifier = Modifier.size(18.dp)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Medium,
                color = TextSecondary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            Text(
                text = value,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.labelLarge,
                color = color,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
        }
    }
}