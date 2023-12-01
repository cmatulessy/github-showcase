package com.carlomatulessy.githubshowcase.overview.ui.model

data class GithubRepositoryInfoUiModel(
    val id: Int,
    val name: String,
    val private: Boolean,
    val avatarImage: String,
    val visibility: String
)