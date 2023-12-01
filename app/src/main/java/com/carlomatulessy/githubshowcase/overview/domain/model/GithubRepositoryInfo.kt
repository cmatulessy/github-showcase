package com.carlomatulessy.githubshowcase.overview.domain.model

import com.carlomatulessy.githubshowcase.detail.ui.model.DetailUiModel
import com.carlomatulessy.githubshowcase.overview.ui.model.GithubRepositoryInfoUiModel

data class GithubRepositoryInfo(
    val id: Int,
    val name: String,
    val fullName: String,
    val description: String?,
    val avatarUrl: String,
    val visibility: String,
    val isPrivate: Boolean,
    val htmlUrl: String
)

fun GithubRepositoryInfo.toUiModel() =
    GithubRepositoryInfoUiModel(
        id = id,
        name = name,
        isPrivate = isPrivate,
        avatarUrl = avatarUrl,
        visibility = visibility
    )

fun GithubRepositoryInfo.toDetailUiModel() =
    DetailUiModel(
        name = name,
        fullName = fullName,
        description = description,
        avatarUrl = avatarUrl,
        htmlUrl = htmlUrl,
        visibility = visibility,
        isPrivate = isPrivate
    )

