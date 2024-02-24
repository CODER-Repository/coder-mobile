package com.coder.siakad.presentation.component.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.coder.siakad.R
import com.coder.siakad.ui.theme.PrimaryBlue10
import com.coder.siakad.ui.theme.PrimaryBlue500
import com.coder.siakad.ui.theme.Typography

@ExperimentalMaterial3Api
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title: String,
    navigateBack: () -> Unit,
//    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        modifier = modifier.background(PrimaryBlue500),
        title = {
            Text(text = title, style = Typography.headlineLarge)
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    navigateBack
                },
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.navigate_back)
                )
            }
        }
    )
}