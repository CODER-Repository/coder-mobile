package com.coder.siakad.presentation.component.input

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
    icon: ImageVector,
    value: String,
    placeholder: String = "",
    onChange: (String) -> Unit = {},
    isChange: Boolean = false,
    isObsecure: Boolean? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    topPadding: Dp = 5.dp,
    bottomPadding: Dp = 5.dp
) {
    var isShowPassword by remember { mutableStateOf(false) }

    Column(modifier.padding(top = topPadding, bottom = bottomPadding)) {
        if (label != "") {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icon,
                    tint = TextPrimary,
                    contentDescription = stringResource(
                        id = R.string.label, label
                    )
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = label, style = Typography.labelSmall)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
        OutlinedTextField(
            value = value,
            onValueChange = onChange,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth(),
//            colors = (if (isChange)ContainerPrimary else ContainerDisable),
            colors = OutlinedTextFieldDefaults.colors(disabledContainerColor = ContainerDisable  ),
            enabled = isChange,
            shape = RoundedCornerShape(8.dp),
            placeholder = {
                Text(
                    text = placeholder, style = if (isChange) {
                        Typography.labelSmall.merge(TextDisable)
                    } else {
                        Typography.labelSmall.merge(PlaceholderPrimary)
                    }
                )

            },
            trailingIcon = {
                if (isObsecure != null && isObsecure) {
                    IconButton(onClick = {
                        isShowPassword = !isShowPassword
                    }) {
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
            singleLine = true,
            maxLines = 1,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = PrimaryBlue500,
                unfocusedBorderColor = PrimaryBlue500,
                focusedLabelColor = PrimaryBlue500,
                cursorColor = PrimaryBlue500
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SiakadInputTextPreview() {
    SiakadInputText(
        value = "",
        onChange = {},
        label = "Test",
        isChange = true,
        isObsecure = true,
        icon = Icons.Default.Preview
    )
}