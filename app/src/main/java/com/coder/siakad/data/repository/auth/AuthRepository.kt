package com.coder.siakad.data.repository.auth

import android.app.Application
import com.coder.siakad.data.source.remote.network.request.auth.LoginRequest
import com.coder.siakad.data.source.remote.network.response.auth.LoginSuccessResponse
import com.coder.siakad.data.source.remote.network.retrofit.ApiService
import com.coder.siakad.data.util.Resource
import com.coder.siakad.domain.repository.SiakadRepository
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

//@ActivityScoped
//class AuthRepository @Inject constructor(
//    private val api: ApiService
//) {
//    suspend fun login(request: LoginRequest): Resource<LoginSuccessResponse> {
//        val response = try {
//            api.login(request)
//        } catch (e: Exception) {
//            return Resource.Error(message = "User Not Found")
//        }
//        return Resource.Success(response)
//    }
//}

@ActivityScoped
class AuthRepository(
    private val api: ApiService,
) : SiakadRepository {
    init {

    }
    override suspend fun login(request: LoginRequest): Resource<LoginSuccessResponse> {
        val response = try {
            api.login(request)
        } catch (e: Exception) {
            return Resource.Error(message = "User Not Found")
        }
        return Resource.Success(response)
    }
}