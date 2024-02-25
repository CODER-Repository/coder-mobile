package com.coder.siakad.presentation.component.input

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTimeFilled
import androidx.compose.material.icons.filled.Preview
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.coder.siakad.R
import com.coder.siakad.ui.theme.ContainerDisable
import com.coder.siakad.ui.theme.ContainerPrimary
import com.coder.siakad.ui.theme.Outline
import com.coder.siakad.ui.theme.OutlineFocused
import com.coder.siakad.ui.theme.PlaceholderPrimary
import com.coder.siakad.ui.theme.PrimaryBackground
import com.coder.siakad.ui.theme.PrimaryBlue500
import com.coder.siakad.ui.theme.TextDisable
import com.coder.siakad.ui.theme.TextPrimary
import com.coder.siakad.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiakadInputText(
    modifier: Modifier = Modifier,
    label: String = "",
    icon: Painter,
    value: String,
    placeholder: String = "",
    onValueChange: (String) -> Unit = {},
    enable: Boolean = true,
    readOnly: Boolean = false,
    isObsecure: Boolean? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    minLines: Int = 1,
    maxLines: Int = 3,
    supportingText: @Composable (() -> Unit)? = { Text(text = stringResource(id = R.string.required)) },
    isError: Boolean = false
) {
    var isShowPassword by remember { mutableStateOf(false) }

    Column(modifier) {
        if (label != "") {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = icon,
                    tint = TextPrimary,
                    contentDescription = stringResource(
                        id = R.string.label, label
                    )
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = label, style = MaterialTheme.typography.labelMedium)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
//                .height(48.dp)
                .align(Alignment.CenterHorizontally),
            colors =
            OutlinedTextFieldDefaults.colors(
                focusedBorderColor = OutlineFocused,
                unfocusedBorderColor = Outline,
                focusedLabelColor = OutlineFocused,
                cursorColor = Outline,
                unfocusedContainerColor = ContainerPrimary,
                focusedContainerColor = ContainerPrimary,
                disabledContainerColor = ContainerDisable,
                disabledTextColor = TextDisable,
                focusedTextColor = TextPrimary
            ),
            textStyle = MaterialTheme.typography.labelSmall,
            enabled = enable,
            readOnly = readOnly,
            shape = RoundedCornerShape(8.dp),
            placeholder = {
                Text(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    text = placeholder
                )
            },
            trailingIcon = {
                if (isObsecure != null && isObsecure) {
                    IconButton(onClick = { isShowPassword = !isShowPassword }) {
                        Icon(
                            painter = painterResource(id = if (!isShowPassword) R.drawable.visible else R.drawable.visible_off),
                            contentDescription = stringResource(id = R.string.is_show_password)
                        )

                    }
                }
            },
            visualTransformation = if (isObsecure != null && isObsecure) {
                if (isShowPassword) VisualTransformation.None else PasswordVisualTransformation()
            } else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            maxLines = maxLines,
            minLines = minLines,
            supportingText = supportingText,
            isError = isError
            )
    }
}

@Preview(showBackground = true)
@Composable
fun SiakadInputTextPreview() {
    SiakadInputText(
        value = "test",
        onValueChange = {},
        label = "Oke",
        enable = true,
        isObsecure = false,
        icon = painterResource(id = R.drawable.ic_academic_data)
    )
}