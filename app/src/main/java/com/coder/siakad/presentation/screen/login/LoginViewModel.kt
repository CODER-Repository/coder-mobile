package com.coder.siakad.presentation.screen.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coder.siakad.data.source.remote.network.request.auth.LoginRequest
import com.coder.siakad.data.source.remote.network.response.auth.LoginSuccessResponse
import com.coder.siakad.data.util.Resource
import com.coder.siakad.domain.model.UserModel
import com.coder.siakad.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _uiLoginState: MutableStateFlow<Resource<LoginSuccessResponse>> =
        MutableStateFlow(Resource.Loading()) // Initialize Loading without parameters

    val uiLoginState: StateFlow<Resource<LoginSuccessResponse>>
        get() = _uiLoginState

    //Fake Data
//    private val _uiLoginState: MutableStateFlow<Resource<UserModel>> =
//        MutableStateFlow(Resource.Loading()) // Initialize Loading without parameters
//
//    val uiLoginState: StateFlow<Resource<UserModel>>
//        get() = _uiLoginState

    //Di collect datanya dan baru ditampilkan di UI/Screen
    //Kelebihan State bisa kita mapping, Filter datanya. dan nyimpen state
    fun login(loginRequest: LoginRequest) {
//        fun login(email: String) {
            viewModelScope.launch {
            authRepository.login(loginRequest).collectLatest { result ->
                when (result) {
                    is Resource.Success -> {
                        // Ketika permintaan berhasil, Aku ingin mengatur _uiLoginState menjadi Resource.Success dengan data yang diterima
                        _uiLoginState.value =
                            Resource.Success(result.data) // Mengatur _uiLoginState ke Resource.Success dengan data yang diterima
                        Log.e("Error", "${result.message}")
                    }

                    is Resource.Loading -> {
                        _uiLoginState.value = Resource.Loading()
                    }

                    is Resource.Error -> {
                        // Ketika terjadi kesalahan, Aku ingin dapat menangani logika kesalahan di sini
                        _uiLoginState.value = Resource.Error(
                            message = result.message ?: "Unknown error"
                        ) // Mengatur _uiLoginState ke Resource.Error dengan pesan kesalahan yang diterima dari repositori
                        Log.e("Error", "${result.message}")
                    }
                }
            }
        }
    }
}