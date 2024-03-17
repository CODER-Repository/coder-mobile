package com.coder.siakad.presentation.screen.attendance.utils

fun String.lectureName(): String {
    val words = this.split(" ")
    val firstChar = words.mapNotNull { if (it.isNotEmpty()) it[0].uppercaseChar() else null }
    return firstChar.joinToString("")
}