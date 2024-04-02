package com.coder.siakad.domain.repository

import com.coder.siakad.data.source.remote.network.request.auth.LoginRequest
import com.coder.siakad.data.source.remote.network.response.auth.LoginSuccessResponse
import com.coder.siakad.data.util.Resource

interface SiakadRepository {
    suspend fun login(request: LoginRequest): Resource<LoginSuccessResponse>
}