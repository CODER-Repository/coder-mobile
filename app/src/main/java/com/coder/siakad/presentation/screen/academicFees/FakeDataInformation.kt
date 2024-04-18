package com.coder.siakad.presentation.screen.academicFees

import androidx.compose.ui.graphics.painter.Painter

data class FakeInformation(
    val title: String = "",
    val content: String = "",
    val imageContent: String
)
object FakeDataInformation {
    val dataFake = listOf(
        FakeInformation(
            title = "Beasiswa Wajib",
            content = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            imageContent = "https://i.pinimg.com/736x/bc/20/94/bc20948f3bccfd926b41688b38b3d9c9.jpg"
        ),
        FakeInformation(
            title = "Beasiswa Wajib",
            content = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            imageContent = "https://i.pinimg.com/736x/bc/20/94/bc20948f3bccfd926b41688b38b3d9c9.jpg"
        ),
        FakeInformation(
            title = "Beasiswa Wajib",
            content = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            imageContent = "https://i.pinimg.com/736x/bc/20/94/bc20948f3bccfd926b41688b38b3d9c9.jpg"
        )
    )
}