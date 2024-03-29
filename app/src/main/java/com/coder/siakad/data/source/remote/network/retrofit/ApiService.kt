package com.coder.siakad.data.source.remote.network.retrofit

import com.coder.siakad.data.source.remote.network.response.DashboardResponse
import com.coder.siakad.data.source.remote.network.response.ScheduleResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("dashboard")
    suspend fun getDashboard() : DashboardResponse

    @GET("schedule")
    suspend fun getSchedule(
        @Query("today") today: Boolean = false
    ) : ScheduleResponse
}