package com.coder.siakad.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.coder.siakad.R

@Composable
fun MaintenanceScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(). padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Page Not Found", style = MaterialTheme.typography.titleLarge)
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_maintenance),
            contentDescription = "Not Found"
        )
        Text(text = "Still Under Maintenance", style = MaterialTheme.typography.titleLarge)
    }
}