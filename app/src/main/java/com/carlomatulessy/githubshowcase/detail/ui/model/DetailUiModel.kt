package com.carlomatulessy.githubshowcase.detail.ui.model

data class DetailUiModel(
    val name: String,
    val fullName: String,
    val description: String?,
    val avatarUrl: String,
    val htmlUrl: String,
    val visibility: String,
    val isPrivate: Boolean
)