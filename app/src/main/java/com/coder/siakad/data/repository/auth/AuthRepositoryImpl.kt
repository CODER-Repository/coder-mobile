package com.coder.siakad.data.repository.auth

import com.coder.siakad.data.source.local.localPreferences.UserPreference
import com.coder.siakad.data.source.remote.network.FakeDataUser
import com.coder.siakad.data.source.remote.network.request.auth.LoginRequest
import com.coder.siakad.data.source.remote.network.response.auth.LoginSuccessResponse
import com.coder.siakad.data.source.remote.network.retrofit.ApiService
import com.coder.siakad.data.util.Resource
import com.coder.siakad.domain.model.UserModel
import com.coder.siakad.domain.repository.AuthRepository
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.Flow
import com.coder.siakad.data.util.Constants.HandleError
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
@ActivityScoped
class AuthRepositoryImpl(
    private val api: ApiService,
//    private val pref: UserPreference
) : AuthRepository {
    //:Exception = generic
    fun handleError(exception: Exception): Resource<LoginSuccessResponse> {
        return when (exception) {
            is HttpException -> Resource.Error(
                message = exception.localizedMessage ?: "Unknown Error"
            )

            is IOException -> Resource.Error(message = exception.localizedMessage ?: "No Internet")
            else -> Resource.Error(message = "Unknown error occurred")
        }
    }

    override suspend fun login(loginRequest: LoginRequest): Flow<Resource<LoginSuccessResponse>> =
        flow {
            try {
                val response = api.login(loginRequest)
//                saveUser(user = )
                return@flow emit(Resource.Success(response))
            } catch (e: Exception) {
                emit(handleError(e))
            }
        }
}