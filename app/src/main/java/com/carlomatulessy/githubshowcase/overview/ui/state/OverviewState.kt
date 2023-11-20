package com.carlomatulessy.githubshowcase.overview.ui.state

import com.carlomatulessy.githubshowcase.overview.ui.model.GithubRepositoryInfoUiModel

sealed interface OverviewState {
    data object Loading : OverviewState
    data class Overview(val uiModel: GithubRepositoryInfoUiModel) : OverviewState
    data class Error(val e: Exception) : OverviewState
}