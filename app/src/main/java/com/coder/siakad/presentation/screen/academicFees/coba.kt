@file:OptIn(ExperimentalFoundationApi::class)

package com.coder.siakad.presentation.screen.academicFees

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun test() {
    val pagerState = rememberPagerState(pageCount = {
        10
    })
    Column(modifier = Modifier.fillMaxWidth().fillMaxSize()) {

    }

    HorizontalPager(state = pagerState) { page ->
        // Our page content
        Text(
            text = "Page: $page",
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        )
    }

// scroll to page
    val coroutineScope = rememberCoroutineScope()
    Button(onClick = {
        coroutineScope.launch {
            // Call scroll to on pagerState
            pagerState.animateScrollToPage(5)
        }
    }, modifier = Modifier.wrapContentHeight(Alignment.Bottom) ) {
        Text("Jump to Page 5")
    }
}