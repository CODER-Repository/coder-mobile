package com.coder.siakad.presentation.screen.schedule

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coder.siakad.data.source.remote.network.response.dashboard.DashboardResponse
import com.coder.siakad.data.source.remote.network.response.schedule.ScheduleResponse
import com.coder.siakad.data.util.Resource
import com.coder.siakad.domain.repository.ScheduleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val scheduleRepository: ScheduleRepository
): ViewModel() {
    private val _uiScheduleState: MutableStateFlow<Resource<ScheduleResponse>> =
        MutableStateFlow(Resource.Loading())

    val uiScheduleState: StateFlow<Resource<ScheduleResponse>>
        get() = _uiScheduleState

    fun schedule(){
        viewModelScope.launch {
            scheduleRepository.schedule().collectLatest { result->
                when(result) {
                    is Resource.Success -> {
                        _uiScheduleState.value = Resource.Success(result.data)
                    }
                    is Resource.Error -> {
                        _uiScheduleState.value = Resource.Error(
                            message = result.message ?: "Unkown Error"
                        )
                    }
                    is Resource.Loading -> {
                        _uiScheduleState.value = Resource.Loading()
                    }
                }
            }
        }
    }
}