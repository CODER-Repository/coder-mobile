package com.coder.siakad.domain.model

data class DashboardModel(
    val currentGPA: Float,
    val totalCreditCourse: Int,
    val currentSemester: String,
    val unpaidFees: Long
)
