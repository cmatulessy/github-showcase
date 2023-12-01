package com.carlomatulessy.githubshowcase.detail.ui.state

import com.carlomatulessy.githubshowcase.detail.ui.model.DetailUiModel

sealed interface DetailState {
    data object Loading : DetailState
    data class Overview(val uiModel: DetailUiModel) : DetailState
    data class Error(val e: Exception) : DetailState
}