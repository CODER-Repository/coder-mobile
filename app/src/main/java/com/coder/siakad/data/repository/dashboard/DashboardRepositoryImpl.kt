package com.coder.siakad.data.repository.dashboard

import com.coder.siakad.data.source.remote.network.response.dashboard.DashboardResponse
import com.coder.siakad.data.source.remote.network.retrofit.ApiService
import com.coder.siakad.data.util.Resource
import com.coder.siakad.domain.repository.DashboardRepository
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import java.lang.Exception

@ActivityScoped
class DashboardRepositoryImpl(
    private val api: ApiService,
) : DashboardRepository {
    private fun handleError(exception: Exception): Resource<DashboardResponse> {
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

    override suspend fun dashboard(): Flow<Resource<DashboardResponse>> =
        flow {
            try {
                val response = api.getDashboard()
                emit(Resource.Success(response))
            } catch (e: Exception) {
                emit(handleError(e))
            }
        }
}