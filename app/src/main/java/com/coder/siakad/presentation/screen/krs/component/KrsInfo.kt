package com.coder.siakad.presentation.screen.krs.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AssignmentInd
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coder.siakad.R
import com.coder.siakad.ui.theme.SiakadTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.coder.siakad.ui.theme.TextSecondary

@Composable
fun KrsInfo(
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
            Icon (
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

@Preview
@Composable
fun KrsInfoPreview() {
    SiakadTheme {
        Surface(color = Color.White) {
            KrsInfo(
                title = "Nama",
                icon = Icons.Default.AssignmentInd,
                value = "Fillah Amanda S"
            )
        }
    }
}