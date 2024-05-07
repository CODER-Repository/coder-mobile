package com.coder.siakad.presentation.screen.dashboard

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coder.siakad.data.source.remote.network.response.dashboard.DashboardResponse
import com.coder.siakad.data.util.Resource
import com.coder.siakad.domain.repository.DashboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val dashboardRepository: DashboardRepository
) : ViewModel() {
    private val _uiDashboardInfoState: MutableStateFlow<Resource<DashboardResponse>> =
        MutableStateFlow(Resource.Loading())

    val uiDashboardInfoState: StateFlow<Resource<DashboardResponse>>
        get() = _uiDashboardInfoState

    fun dashboard(){
        viewModelScope.launch {
            dashboardRepository.dashboard().collectLatest { result ->
                when(result) {
                    is Resource.Success -> {
                        _uiDashboardInfoState.value =
                            Resource.Success(result.data)
                        Log.e("Succes", "${result.message}")
                    }
                    is Resource.Loading -> {
                        _uiDashboardInfoState.value = Resource.Loading()
                    }
                    is Resource.Error -> {
                        _uiDashboardInfoState.value = Resource.Error(
                            message = result.message ?: "Unkown Error"
                        )
                        Log.e("dashboard", "${result.message}")
                    }
                }
            }
        }
    }
}