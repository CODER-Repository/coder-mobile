package com.coder.siakad.presentation.screen.academicFees.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.AsyncImage
import com.coder.siakad.presentation.component.CustomButton
import com.coder.siakad.ui.theme.SiakadTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OverLayInformation(
    pagerState: PagerState,
    page: Int,
    title: String,
    imageContent: String,
    content: String
) {
    Card(
        shape = CardDefaults.elevatedShape,
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(154.dp)
            .padding(end = 4.dp)
            .clip(RoundedCornerShape(4.dp)),
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val pageOffset = pagerState.currentPageOffsetFraction
            AsyncImage(
                model = imageContent,
                contentDescription = "Gambar",
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .width(120.dp)
                    .background(Color.Gray)
                    .graphicsLayer {
                        val scale = lerp(1f, 1.75f, pageOffset)
                        scaleX = scale
                        scaleY = scale
                    },
                contentScale = ContentScale.Crop,

                )
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = title,
                    maxLines = 1,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
                )
                Text(
                    text = content,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Normal)

                )
                CustomButton(
                    varSizeButton = "",
                    varOutline = "isOutline",
                    modifier = Modifier.wrapContentHeight(Alignment.Bottom), // Mengubah modifier menjadi wrapContentSize()
                    text = {
                        Text(
                            text = "Detail",
                            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Normal)
                        )
                    },
                    onClick = { /*TODO*/ },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowRight,
                            contentDescription = null,
//                            modifier = Modifier.padding(start = 8.dp)
                        )
                    },
                )
            }
        }
    }
}


//@Preview
//@Composable
//fun overLayInformationPrev() {
//    SiakadTheme {
//        overLayInformation(
//            title = "Beasiswa tetap",
//            content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras sed risus ullamcorper, imperdiet purus vehicula, faucibus metus. Donec et velit risus. Nunc malesuada finibus nunc, eu lobortis ante efficitur nec. Donec malesuada lacinia malesuada. Sed sed faucibus tellus, non rhoncus neque. Sed placerat est non urna pellentesque semper. Praesent justo purus, convallis quis leo eu, semper porta urna. Sed sed dui nisi. Proin sed purus dui. Sed maximus erat vitae sem pretium iaculis. Morbi blandit accumsan tortor, mollis pharetra orci pulvinar id. Nulla enim risus, sagittis a placerat eget, imperdiet at arcu. Sed malesuada consectetur diam nec feugiat. Etiam consectetur hendrerit risus, in ullamcorper mauris porta eget.",
//            imageContent = "https://studio.mrngroup.co/storage/app/media/Prambors/Editorial%203/Anime-20230828121723.webp?tr=w-600",
//            page = 1,
//        )
//    }
//}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun OverLayInformationPreview() {
    val pagerState = rememberPagerState(pageCount = { 3 })
    val page = remember { 0 } // Set the page index for preview
    val title = "Sample Title"
    val imageContent =
        "https://studio.mrngroup.co/storage/app/media/Prambors/Editorial%203/Anime-20230828121723.webp?tr=w-600"
    val content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer euismod."

    SiakadTheme {
    OverLayInformation(pagerState, page, title, imageContent, content)
    }
}