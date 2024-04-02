package com.coder.siakad.presentation.screen.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coder.siakad.data.repository.auth.AuthRepository
import com.coder.siakad.data.source.remote.network.request.auth.LoginRequest
import com.coder.siakad.data.source.remote.network.response.auth.LoginSuccessResponse
import com.coder.siakad.data.util.Resource
import com.coder.siakad.domain.repository.SiakadRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val siakadRepository: SiakadRepository
): ViewModel() {
    private val _uiLoginState: MutableStateFlow<Resource<LoginSuccessResponse>> =
        MutableStateFlow(Resource.Loading()) // Initialize Loading without parameters

    val uiLoginState: StateFlow<Resource<LoginSuccessResponse>>
        get() = _uiLoginState

    fun login(loginRequest: LoginRequest){
        viewModelScope.launch {
            val result = siakadRepository.login(loginRequest)
            when(result){
                is Resource.Success -> {
                    // Ketika permintaan berhasil, Aku ingin mengatur _uiLoginState menjadi Resource.Success dengan data yang diterima
                    _uiLoginState.value = Resource.Success(result.data) // Mengatur _uiLoginState ke Resource.Success dengan data yang diterima
                Log.e("Error", "${result.message}")
                }
                is Resource.Loading -> {
                    _uiLoginState.value = Resource.Loading()
                }
                is Resource.Error -> {
                    // Ketika terjadi kesalahan, Aku ingin dapat menangani logika kesalahan di sini
                    _uiLoginState.value = Resource.Error(message = result.message ?: "Unknown error") // Mengatur _uiLoginState ke Resource.Error dengan pesan kesalahan yang diterima dari repositori
                    Log.e("Error", "${result.message}")
                }
            }
        }
    }
}