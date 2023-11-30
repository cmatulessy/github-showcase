package com.carlomatulessy.githubshowcase.overview.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlomatulessy.githubshowcase.core.data.model.ApiResponse
import com.carlomatulessy.githubshowcase.overview.domain.model.toUiModel
import com.carlomatulessy.githubshowcase.overview.domain.usecase.GetOverviewUseCase
import com.carlomatulessy.githubshowcase.overview.ui.model.GithubRepositoryInfoUiModel
import com.carlomatulessy.githubshowcase.overview.ui.state.OverviewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class OverviewViewModel(
    private val useCase: GetOverviewUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<OverviewState> = MutableStateFlow(OverviewState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() =
        useCase()
            .onStart { _uiState.update { OverviewState.Loading }  }
            .onEach { response ->
                when(response) {
                    is ApiResponse.Failed -> onError(response.e)
                    is ApiResponse.Success -> onSuccess(response.data.map { it.toUiModel() })
                }
            }
            .catch { onError(it as Exception) }
            .launchIn(viewModelScope)

    private fun onError(e: Exception) {
        Log.d("TEST", e.toString())
        _uiState.update { OverviewState.Error(e) }
    }

    private fun onSuccess(uiModels: List<GithubRepositoryInfoUiModel>) {
        _uiState.update { OverviewState.Overview(uiModels) }
    }
}