package com.coder.siakad.presentation.screen.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.coder.siakad.R
import com.coder.siakad.ui.theme.PrimaryBlue500
import com.coder.siakad.ui.theme.TextDisable
import com.coder.siakad.ui.theme.Typography

@Composable
fun ProfileHeader(
    modifier: Modifier = Modifier,
    username: String,
    iconUrl: String,
    nim: String,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AsyncImage(
            modifier = modifier
                .clip(CircleShape)
                .size(75.dp)
                .background(PrimaryBlue500),
            model = iconUrl,
            contentDescription = stringResource(id = R.string.img_profile),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = modifier.height(5.dp))
        Text(
            modifier = modifier,
            text = username,
            style = Typography.labelLarge.merge(
                PrimaryBlue500,
                fontWeight = FontWeight.SemiBold
            ),
        )
        Text(
            text = nim,
            modifier = modifier,
            style = Typography.labelSmall.merge(TextDisable)
        )
    }
}