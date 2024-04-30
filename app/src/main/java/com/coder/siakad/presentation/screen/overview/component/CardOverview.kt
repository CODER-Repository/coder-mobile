package com.coder.siakad.presentation.screen.overview.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coder.siakad.R
import com.coder.siakad.ui.theme.SiakadTheme
import com.coder.siakad.ui.theme.TextSecondary

@Composable
fun CardOverview(
    modifier: Modifier = Modifier,
    colorTitle: Color,
    colorLabel: Color,
    grade: String,
    name: String,
    title: String,
    time: String,
    place: String,
    status: String
) {
    Card(
        shape = CardDefaults.outlinedShape,
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .padding(end = 16.dp, start = 0.dp)
            .width(196.dp)
            .height(268.dp)
            .shadow(ambientColor = Color.Blue, elevation = 5.dp, clip = true)
            .clip(RoundedCornerShape(10.dp)),
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .padding(top = 6.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .background(
                        colorTitle
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = name,
                    color = Color.White,
                    style = MaterialTheme.typography.labelMedium.copy(fontStyle = FontStyle.Italic)
                )

            }
            Spacer(modifier = modifier.width(8.dp))
            Text(
                modifier = modifier,
                text = grade,
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.SemiBold),
            )
        }

        Column {
            Divider(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(top = 12.dp, start = 20.dp, bottom = 32.dp)
        ) {
            Row {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_overviewtask),
                    contentDescription = title,
                    modifier = Modifier.padding(end = 10.dp)
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelMedium.copy(
                        color = TextSecondary,
                        fontWeight = FontWeight.SemiBold
                    ),
                )
            }
            Row {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_overviewtime),
                    contentDescription = null,
                    modifier = Modifier.padding(end = 10.dp)
                )
                Text(
                    text = time,
                    style = MaterialTheme.typography.labelMedium.copy(
                        color = TextSecondary,
                    )
                )
            }
            Row {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_overviewplace),
                    contentDescription = null,
                    modifier = Modifier.padding(end = 10.dp)
                )
                Text(
                    text = place,
                    style = MaterialTheme.typography.labelMedium.copy(color = TextSecondary)
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            Box(
                modifier = modifier
                    .background(
                        shape = RoundedCornerShape(16.dp),
                        color = colorLabel.copy(alpha = 0.3f)
                    ),
                contentAlignment = Alignment.BottomEnd,
            ) {
                Text(
                    text = status,
                    modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                    color = colorLabel,
                    style = MaterialTheme.typography.labelSmall
                )

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CardOverviewPreview() {
    SiakadTheme {
        CardOverview(
            name = "PW",
            grade = "IF-2B",
            title = "Pemrograman Web",
            time = "07:30 - 09:10",
            place = "LAB - CODE",
            status = "Telah Selesai",
            colorTitle = MaterialTheme.colorScheme.primary,
            colorLabel = MaterialTheme.colorScheme.primary
        )
    }
}