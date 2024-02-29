package com.coder.siakad.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.coder.siakad.R

val EuclidCircularFontFamily = FontFamily(
    Font(R.font.euclid_circular_a_regular),
    Font(R.font.euclid_circular_a_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.euclid_circular_a_medium, FontWeight.Medium),
    Font(R.font.euclid_circular_a_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.euclid_circular_a_semibold, FontWeight.SemiBold),
    Font(R.font.euclid_circular_a_semibold, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.euclid_circular_a_bold, FontWeight.Bold),
    Font(R.font.euclid_circular_a_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.euclid_circular_a_light, FontWeight.Light),
    Font(R.font.euclid_circular_a_light_italic, FontWeight.Light, FontStyle.Italic),
)

// Set of Material typography styles to start with
val Typography = Typography(
    // Headline
    headlineSmall = TextStyle(
        fontFamily = EuclidCircularFontFamily,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = EuclidCircularFontFamily,
        fontSize = 24.sp,
        lineHeight = 30.sp,
        letterSpacing = 0.sp
    ),

    // Paragraph
    bodySmall = TextStyle(
        fontFamily = EuclidCircularFontFamily,
        fontSize = 12.sp,
        lineHeight = 15.sp,
        letterSpacing = 0.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = EuclidCircularFontFamily,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = EuclidCircularFontFamily,
        fontSize = 18.sp,
        lineHeight = 23.sp,
        letterSpacing = 0.sp
    ),

    // Label
    labelSmall = TextStyle(
        fontFamily = EuclidCircularFontFamily,
        fontSize = 12.sp,
        lineHeight = 15.sp,
        letterSpacing = 0.sp
    ),
    labelMedium = TextStyle(
        fontFamily = EuclidCircularFontFamily,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp
    ),
    labelLarge = TextStyle(
        fontFamily = EuclidCircularFontFamily,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    )
)

val Typography.tabInactive: TextStyle
    get() = TextStyle(
        fontFamily = EuclidCircularFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp
    )
val Typography.tabActive: TextStyle
    get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp
    )
