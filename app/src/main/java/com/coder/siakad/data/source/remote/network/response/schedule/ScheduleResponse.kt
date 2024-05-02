package com.coder.siakad.data.source.remote.network.response.schedule

import com.google.gson.annotations.SerializedName

data class ScheduleResponse(

    @field:SerializedName("data")
	val data: ScheduleData,

    @field:SerializedName("statusCode")
	val statusCode: Int,

    @field:SerializedName("status")
	val status: Boolean
)

data class DayItem(

	@field:SerializedName("course_id")
	val courseId: String,

	@field:SerializedName("course_room")
	val courseRoom: String,

	@field:SerializedName("course_name")
	val courseName: String,

	@field:SerializedName("time_start")
	val timeStart: String,

	@field:SerializedName("time_end")
	val timeEnd: String,

	@field:SerializedName("schedule_id")
	val scheduleId: Int,

	@field:SerializedName("faculty")
	val faculty: String
)

data class ScheduleData(

    @field:SerializedName("tuesday")
	val tuesday: List<DayItem>,

    @field:SerializedName("wednesday")
	val wednesday: List<DayItem>,

    @field:SerializedName("thursday")
	val thursday: List<DayItem>,

    @field:SerializedName("friday")
	val friday: List<DayItem>,

    @field:SerializedName("monday")
	val monday: List<DayItem>
)
