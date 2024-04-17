package com.coder.siakad.presentation.screen.krs.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.coder.siakad.ui.theme.SiakadTheme

@Composable
fun KrsNotification(
    info: String,
    backgroundColor: Color,
    textColor: Color,
    rectangleWidth: Dp,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .height(42.dp)
                    .width(rectangleWidth)
                    .background(textColor)
            )
            Text(
                text = info,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Normal, color = textColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(backgroundColor.copy(alpha = 0.2f))
                    .padding(vertical = 10.dp, horizontal = 32.dp)
            )
        }
    }
}

@Preview
@Composable
private fun KrsNotificationPrev() {
    SiakadTheme {
        KrsNotification(
            info = "KRS sudah disetujui dosen wali",
            backgroundColor = Color(0xFF1EB193),
            textColor = Color(0xFF1EB193),
            rectangleWidth = 10.dp,
            modifier = Modifier 
        )
    }
}