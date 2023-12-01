package com.carlomatulessy.githubshowcase.detail.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.carlomatulessy.githubshowcase.core.data.model.ApiResponse
import com.carlomatulessy.githubshowcase.detail.domain.usecase.GetDetailUseCase
import com.carlomatulessy.githubshowcase.detail.ui.event.DetailEvent
import com.carlomatulessy.githubshowcase.detail.ui.model.DetailUiModel
import com.carlomatulessy.githubshowcase.detail.ui.state.DetailState
import com.carlomatulessy.githubshowcase.overview.domain.model.toDetailUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update

class DetailViewModel(
    private val useCase: GetDetailUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<DetailState> = MutableStateFlow(DetailState.Loading)
    val uiState = _uiState.asStateFlow()

    fun dispatch(event: DetailEvent) =
        when (event) {
            is DetailEvent.LoadInfoForRepositoryWithId -> loadData(event.id)
        }
    private fun loadData(id: Int) =
        useCase(id)
            .onStart { _uiState.update { DetailState.Loading } }
            .onEach { response ->
                when(response) {
                    is ApiResponse.Failed -> onError(response.e)
                    is ApiResponse.Success -> onSuccess(response.data.toDetailUiModel())
                }
            }

    private fun onError(e: Exception) {
        _uiState.update { DetailState.Error(e) }
    }

    private fun onSuccess(uiModel: DetailUiModel) {
        _uiState.update { DetailState.Overview(uiModel) }
    }
}