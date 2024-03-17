package com.coder.siakad.presentation.screen.presensi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.coder.siakad.presentation.component.input.SiakadMultiLineInputText

@Composable
fun Test() {
    var text by remember {
        mutableStateOf("")
    }
    SiakadMultiLineInputText(
        value = text,
        onValueChanged = { text = it },
        placeHolder = "nsksccic\nnkdld\ndnmdsm",
        maxLines = 7
    )
}

@Preview
@Composable
fun TestPreview() {
    Test()
}