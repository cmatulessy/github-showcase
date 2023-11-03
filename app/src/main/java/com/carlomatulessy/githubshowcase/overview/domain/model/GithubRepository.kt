package com.carlomatulessy.githubshowcase.overview.domain.model

data class GithubRepository(
    val name: String,
    val private: Boolean,
    val avatarImage: String,
    val visibility: String
)
