@file:OptIn(ExperimentalFoundationApi::class)

package com.coder.siakad.presentation.screen.academicFees

import android.content.om.OverlayInfo
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coder.siakad.presentation.component.CustomButton
import com.coder.siakad.presentation.component.header.TopBar
import com.coder.siakad.presentation.navigation.Screen
import com.coder.siakad.presentation.screen.academicFees.component.OverLayInformation
import com.coder.siakad.ui.theme.SiakadTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator

@ExperimentalMaterial3Api
@Composable
fun AcademicFeesScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopBar(
                title = "Biaya Akademik",
                modifier = modifier
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
                .background(MaterialTheme.colorScheme.background),
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Informasi Beasiswa Terbaru",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold)
                )
                InformationSlider()
                Spacer(modifier = modifier.height(2.dp))
                Text(
                    text = "Jenis Tagihan",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold)
                )
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    CustomButton(
                        text = {
                            Text(text = "Belum Terbayar", style = MaterialTheme.typography.bodyMedium)
                        },
                        onClick = { /*TODO*/ },
                        varSizeButton = "",
                        varOutline = ""
                    )
                    CustomButton(
                        text = {
                            Text(text = "Riwayat Pembayaran", style = MaterialTheme.typography.bodyMedium)
                        }, onClick = { /*TODO*/ },
                        varSizeButton = "",
                        varOutline = "isOutline"
                    )
                }
            }
        }
        Column {
        }
    }
}

//Banner Carousel
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InformationSlider(
    modifier: Modifier = Modifier
) {
    val pagerState =
        rememberPagerState(initialPage = 0, pageCount = { FakeDataInformation.dataFake.size })
    val animationScope = rememberCoroutineScope()
    HorizontalPager(
        state = pagerState,
        userScrollEnabled = true,
    ) { page ->
        Box(modifier = Modifier.fillMaxSize()) {
            val info = FakeDataInformation.dataFake.getOrNull(page)
            info?.let {
                OverLayInformation(
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

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
private fun AcademicFeesPreview() {
    SiakadTheme {
        AcademicFeesScreen()
    }
}
