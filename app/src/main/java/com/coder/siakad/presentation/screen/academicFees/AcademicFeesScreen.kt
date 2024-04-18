@file:OptIn(ExperimentalFoundationApi::class)

package com.coder.siakad.presentation.screen.academicFees

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coder.siakad.presentation.screen.academicFees.component.overLayInformation
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator

//Banner Carousel
@OptIn(ExperimentalPagerApi::class)
@Composable
fun InformationSlider() {
    val pagerState =
        rememberPagerState(initialPage = 0, pageCount = { FakeDataInformation.dataFake.size })
    val animationScope = rememberCoroutineScope()
    Column(modifier = Modifier.fillMaxWidth()) {
        HorizontalPager(
            state = pagerState,
            userScrollEnabled = true,
            key = { FakeDataInformation.dataFake[it] },
        ) { page ->
            Box(modifier = Modifier.fillMaxSize()) {
                val info = FakeDataInformation.dataFake[page]
                overLayInformation(
                    title = info.title,
                    imageContent = info.imageContent,
                    content = info.content,
                    pagerState = pagerState,
                    page = page
                )
            }
        }
//        HorizontalPagerIndicator(
//            pagerState = pagerState,
//            modifier = Modifier
//                .align(Alignment.CenterHorizontally)
//                .padding(16.dp)
//        )

    }
}

@Preview
@Composable
private fun InformationSliderPreview() {
    InformationSlider()
}
