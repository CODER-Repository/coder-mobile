package com.coder.siakad.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title: String,
    val iconn: ImageVector,
    val screen: Screen,
)