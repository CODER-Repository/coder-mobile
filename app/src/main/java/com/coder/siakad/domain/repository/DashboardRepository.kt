package com.coder.siakad.domain.repository

import com.coder.siakad.data.source.remote.network.response.dashboard.DashboardResponse
import com.coder.siakad.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface DashboardRepository {
    suspend fun dashboard(): Flow<Resource<DashboardResponse>>
}