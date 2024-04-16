package com.coder.siakad.presentation.screen.krs.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ToggleButton() {
    var isButtonKRSToggled by remember { mutableStateOf(true) }
    Row {
        Button(
            onClick = {
                isButtonKRSToggled = true
            },
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isButtonKRSToggled) Color.Blue else Color.White,
            ),
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
        ) {
            Text(
                text = "KRS",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = if (isButtonKRSToggled) Color.White else Color.Blue
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .widthIn(max = 120.dp)
            )
        }

        Button(
            onClick = {
                isButtonKRSToggled = false
            },
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isButtonKRSToggled) Color.White else Color.Blue,
            ),
            border = BorderStroke(1.dp, Color.Blue),
            modifier = Modifier
                .padding(start = 8.dp, end = 16.dp)
        ) {
            Text(
                text = "Daftar Kelas Kuliah",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = if (isButtonKRSToggled) Color.Blue else Color.White
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .widthIn(max = 120.dp)
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreviewToggleButton(){
    ToggleButton()
}