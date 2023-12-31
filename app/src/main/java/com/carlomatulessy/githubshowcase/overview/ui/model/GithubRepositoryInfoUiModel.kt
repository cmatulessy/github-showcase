package com.carlomatulessy.githubshowcase.overview.ui.model

data class GithubRepositoryInfoUiModel(
    val id: Int,
    val name: String,
    val isPrivate: Boolean,
    val avatarUrl: String,
    val visibility: String
)