package com.coder.siakad.data.source.remote.network.response.dashboard

import com.google.gson.annotations.SerializedName

data class DashboardResponse(

	@field:SerializedName("data")
	val data: DashboardData,

	@field:SerializedName("statusCode")
	val statusCode: Int,

	@field:SerializedName("status")
	val status: Boolean
)

data class DashboardData(

	@field:SerializedName("unpaid_fees")
	val unpaidFees: Int,

	@field:SerializedName("current_semester")
	val currentSemester: String,

	@field:SerializedName("current_gpa")
	val currentGpa: Float,

	@field:SerializedName("total_credit_course_taken")
	val totalCreditCourseTaken: Int
)
