package com.coder.siakad.domain.repository

import com.coder.siakad.data.source.remote.network.response.schedule.ScheduleResponse
import com.coder.siakad.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface ScheduleRepository {
    suspend fun schedule(): Flow<Resource<ScheduleResponse>>
}