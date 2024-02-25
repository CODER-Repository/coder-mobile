package com.coder.siakad.presentation.screen.schedule.utils

import androidx.compose.ui.graphics.Color
import com.coder.siakad.ui.theme.Green200
import com.coder.siakad.ui.theme.Green500
import com.coder.siakad.ui.theme.PrimaryBlue200
import com.coder.siakad.ui.theme.PrimaryBlue500
import com.coder.siakad.ui.theme.PrimaryYellow200
import com.coder.siakad.ui.theme.PrimaryYellow500
import com.coder.siakad.ui.theme.Purple200
import com.coder.siakad.ui.theme.Purple500
import com.coder.siakad.ui.theme.Red200
import com.coder.siakad.ui.theme.Red500

enum class ScheduleColor(val colorPrimary: Color, val colorOnPrimary: Color) {
    BLUE(PrimaryBlue200, PrimaryBlue500),
    YELLOW(PrimaryYellow200, PrimaryYellow500),
    GREEN(Green200, Green500),
    PURPLE(Purple200, Purple500),
    RED(Red200, Red500);

    companion object {
        fun getByIndex(index: Int):ScheduleColor = when (index) {
            0 -> BLUE
            1 -> YELLOW
            2 -> GREEN
            3-> PURPLE
            4 -> RED
            else -> BLUE
        }
    }
}