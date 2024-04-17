package com.coder.siakad.presentation.screen.krs.component

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coder.siakad.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToggleButton(onClick: (Boolean) -> Unit) {
    var isButtonKRSToggled by remember { mutableStateOf(true) }
    var isLocked by remember { mutableStateOf(true) }
    val context = LocalContext.current
    val newSchoolYear = arrayOf(
        "Tahun ajaran Ganjil 2021/2022",
        "Tahun ajaran Genap 2022/2023",
        "Tahun ajaran Ganjil 2022/2023",
        "Tahun ajaran Genap 2023/2024",
        "Tahun ajaran Ganjil 2023/2024",
        "Tahun ajaran Genap 2024/2025")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(newSchoolYear[0]) }

    Column {
        Row {
            Button(
                onClick = {
                    isButtonKRSToggled = true
                },
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isButtonKRSToggled) Color(0xFF245399) else Color.White,
                ),
                border = BorderStroke(1.dp, Color(0xFF245399)),
                modifier = Modifier
                    .padding(start = 7.dp, end = 7.dp)
            ) {
                Text(
                    text = "KRS",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = if (isButtonKRSToggled) Color.White else Color(0xFF245399)
                    ),
                    textAlign = TextAlign.Center
                )
            }

            Button(
                onClick = {
                    isButtonKRSToggled = false
                },
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isButtonKRSToggled) Color.White else Color(0xFF245399),
                ),
                border = BorderStroke(1.dp, Color(0xFF245399)),
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
            ) {
                Text(
                    text = "Daftar Kelas Kuliah",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = if (isButtonKRSToggled) Color(0xFF245399) else Color.White
                    ),
                    textAlign = TextAlign.Center
                )
            }
        }

        Row {
            Surface(
                color = if (isLocked) Color(0xFFFAE4B7) else Color(0xFFAFC2DD),
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .clickable {
                        isLocked = !isLocked
                        onClick(isLocked)
                    }
                    .padding(5.dp)
            ) {
                IconButton(
                    onClick = { isLocked = !isLocked },
                    modifier = Modifier
                        .padding(4.dp)
                ) {
                    Icon(
                        imageVector = if (isLocked) Icons.Default.Lock else Icons.Default.LockOpen,
                        contentDescription = if (isLocked) "Terkunci" else "Terbuka",
                        tint = Color.White
                    )
                }
            }

            Box {
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = {
                        expanded = !expanded
                    }
                ) {
                    TextField(
                        value = selectedText,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                        modifier = Modifier
                            .menuAnchor()
                            .padding(top = 5.dp)
                    )

                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        newSchoolYear.forEach { item ->
                            DropdownMenuItem(
                                text = { Text(text = item) },
                                onClick = {
                                    selectedText = item
                                    expanded = false
                                    Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                                }
                            )
                        }
                    }
                }
            }

        }
    }
}
@Preview
@Composable
fun DefaultPreviewToggleButton(){
    ToggleButton {
    }
}