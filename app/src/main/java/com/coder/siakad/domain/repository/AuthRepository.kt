package com.coder.siakad.domain.repository

import com.coder.siakad.data.source.remote.network.request.auth.LoginRequest
import com.coder.siakad.data.source.remote.network.response.auth.LoginSuccessResponse
import com.coder.siakad.data.util.Resource
import com.coder.siakad.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    //With Live Data
//    suspend fun login(request: LoginRequest): Resource<LoginSuccessResponse>

    //With Flow
    suspend fun login(loginRequest: LoginRequest): Flow<Resource<LoginSuccessResponse>>

    //Fake Data
//    suspend fun login(email: String): Flow<Resource<UserModel>>

}