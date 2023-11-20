package com.carlomatulessy.githubshowcase.overview.domain.model

import com.carlomatulessy.githubshowcase.overview.ui.model.GithubRepositoryInfoUiModel

data class GithubRepositoryInfo(
    val name: String,
    val private: Boolean,
    val avatarImage: String,
    val visibility: String
)

fun GithubRepositoryInfo.toUiModel() =
    GithubRepositoryInfoUiModel(
        name = name,
        private = private,
        avatarImage = avatarImage,
        visibility = visibility
    )

