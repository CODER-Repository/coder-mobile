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

//If We Only Use class repo not use interface
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
class AuthRepositoryImpl(
    private val api: ApiService,
//    private val pref: UserPreference
) : AuthRepository {

    //We just need LiveData to Obsserve and trigger UIState. Not Use Flow
//    override suspend fun login(request: LoginRequest): Resource<LoginSuccessResponse> {
//        val response = try {
//            api.login(request)
//        } catch (e: Exception) {
//            return Resource.Error(message = "User Not Found")
//        }
//        return Resource.Success(response)
//    }

    //If We Use Flow in General
    //Why we use this flow doang ga pakek flow state untuk repository?
    //Karena pada dasarnya flow tidak menyimpan state. Dan untuk case ini tdk perlu menyimpan state krna buat apa nyimpan respon error nya yg g berpengaruh ke UI
    //That's why stateFlow digunakan untuk viewModel
//    override suspend fun login(email: String): Flow<Resource<LoginSuccessResponse>> {
//        try {
////            val response = api.login(request)
//            val user = FakeDataUser.dataUser.find { it.email == email }
//            user?.let {
//                return flow { emit(Resource.Success(it)) }
//            } ?: return flow { emit(Resource.Error(message = "Unkown Error")) }
//        } catch (e: HttpException) {
//            return flow { emit(Resource.Error(message = "Unkown Error")) }
//        } catch (io: IOException) {
//            return flow { emit(Resource.Error(message = "Not Found user")) }
//        } catch (e: Exception) {
//            return flow { emit(Resource.Error(message = "Not Found")) }
//        }
//    }

    //Semisal makek throwable gimana trus bedanya sama return

    //    override suspend fun login(loginRequest: LoginRequest): Flow<Resource<LoginSuccessResponse>> {
//        try {
//            val response = api.login(loginRequest)
////            val user = FakeDataUser.dataUser.find { it.email == email }
//            return flow { emit(Resource.Success(response)) }
//        } catch (e: HttpException) {
//            return flow { emit(Resource.Error(message = "Unkown Error")) }
//        } catch (io: IOException) {
//            return flow { emit(Resource.Error(message = "Not Found user")) }
//        } catch (e: Exception) {
//            return flow { emit(Resource.Error(message = "Not Found")) }
//        }
//    }

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
/*
    suspend fun saveUser(user: UserModel) {
        pref.saveUser(user)
    }
 */
}