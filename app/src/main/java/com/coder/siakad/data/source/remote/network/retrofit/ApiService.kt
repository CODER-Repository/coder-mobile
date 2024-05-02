package com.coder.siakad.data.source.remote.network.retrofit

import com.coder.siakad.data.source.remote.network.request.auth.LoginRequest
import com.coder.siakad.data.source.remote.network.response.dashboard.DashboardResponse
import com.coder.siakad.data.source.remote.network.response.schedule.ScheduleResponse
import com.coder.siakad.data.source.remote.network.response.auth.LoginSuccessResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    //AUTH
    @POST("login")
    suspend fun login(@Body request: LoginRequest) : LoginSuccessResponse

//    @POST("logout")
//    suspend fun logout(): InvalidResponse

    @GET("dashboard")
    suspend fun getDashboard() : DashboardResponse

    @GET("schedule")
    suspend fun getSchedule(
        @Query("today") today: Boolean = false
    ) : ScheduleResponse
}