package com.coder.siakad.data.repository.schedule

import com.coder.siakad.data.source.remote.network.response.dashboard.DashboardResponse
import com.coder.siakad.data.source.remote.network.response.schedule.ScheduleResponse
import com.coder.siakad.data.source.remote.network.retrofit.ApiService
import com.coder.siakad.data.util.Resource
import com.coder.siakad.domain.repository.ScheduleRepository
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

@ActivityScoped
class ScheduleRepositoryImpl(
    private val api: ApiService
) : ScheduleRepository {
    private fun handleError(exception: java.lang.Exception): Resource<ScheduleResponse> {
        return when (exception) {
            is HttpException -> Resource.Error(
                message = exception.localizedMessage ?: "Unkown Error"
            )

            is IOException -> Resource.Error(
                message = exception.localizedMessage ?: "Unkown Error"
            )

            else -> Resource.Error(message = "Unknown Error Occurred")
        }
    }

    override suspend fun schedule(): Flow<Resource<ScheduleResponse>> =
        flow {
            try {
                val response = api.getSchedule()
                emit(Resource.Success(response))
            } catch (e: Exception) {
                emit(handleError(e))
            }
        }
}