package com.coder.siakad.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EventAvailable
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coder.siakad.ui.theme.SiakadTheme

//
@Composable
fun sizeButton(variant: String): Modifier {
    if (variant == "isWide") {
        Modifier
            .clip(RoundedCornerShape(2.dp))
            .border(
                width = 2.dp,
                color = Color.Transparent
            )
            .background(color = MaterialTheme.colorScheme.primary)
            .fillMaxWidth()
    } else Modifier
        .clip(RoundedCornerShape(2.dp))
        .border(
            width = 2.dp,
            color = MaterialTheme.colorScheme.primary
        )
        .background(color = MaterialTheme.colorScheme.primary)
    return Modifier
}

@Composable
fun outlineButton(variant: String): ButtonColors {

    val button = if (variant == "isOutline") {
        ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.primary
        )
    } else {
        ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    }
    return button
}

@Composable
fun CustomButton(
//    colors: ButtonColors,
    text: @Composable RowScope.() -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable RowScope.() -> Unit = {},
    trailingIcon: @Composable RowScope.() -> Unit = {},
    varSizeButton: String,
    varOutline: String,
) {
    Button(
        onClick = onClick,
        modifier = sizeButton(variant = varSizeButton),
        colors = outlineButton(variant = varOutline),
        border =  BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            leadingIcon()
            text()
            trailingIcon()
        }
    }
}

@Preview
@Composable
fun PrevButton() {
    SiakadTheme {
        CustomButton(
            text = {
                Text(
                    text = "Selengkapnya",
                    style = MaterialTheme.typography.labelLarge.copy(fontStyle = FontStyle.Italic)
                )
            },
            onClick = { /*TODO*/ },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.EventAvailable,
                    contentDescription = null,
                    modifier = Modifier.padding(start = 8.dp)
                )
            },
            varSizeButton = "isWide",
            varOutline = "isOutline"
        )
    }
}