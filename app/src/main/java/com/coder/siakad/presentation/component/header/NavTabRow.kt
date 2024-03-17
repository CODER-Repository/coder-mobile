package com.coder.siakad.presentation.component.header

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coder.siakad.ui.theme.SiakadTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NavTabRow(
    tabTitles: List<String>,
    pagerState: PagerState,
    onChangeTabIndex: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        containerColor = MaterialTheme.colorScheme.onPrimary,
        indicator = {},
        modifier = modifier.clip(RoundedCornerShape(100.dp))
    ) {
        tabTitles.forEachIndexed { index, title ->
            val selected = pagerState.currentPage == index
            Tab(
                selected = selected,
                onClick = { onChangeTabIndex(index) },
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(100))
                    .background(if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary),
                text = {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.W500
                        ),
                    )
                },
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
private fun Preview() {
    SiakadTheme {
        NavTabRow(tabTitles = listOf("title 1", "title 2"), pagerState = rememberPagerState {
            2
        }, onChangeTabIndex = {})
    }
}