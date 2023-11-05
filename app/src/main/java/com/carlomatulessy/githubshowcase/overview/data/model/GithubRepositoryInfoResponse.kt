package com.carlomatulessy.githubshowcase.overview.data.model

import com.carlomatulessy.githubshowcase.overview.domain.model.GithubRepositoryInfo
import kotlinx.serialization.Serializable

@Serializable
data class GithubRepositoryInfoResponse(
    val name: String,
    val private: Boolean,
    val owner: OwnerResponse,
    val visibility: String
)

@Serializable
data class OwnerResponse(
    val avatarUrl: String // TODO double check if this works, original field name is avatar_url
)

fun GithubRepositoryInfoResponse.toDomain() =
    GithubRepositoryInfo(
        name = name,
        private = private,
        avatarImage = owner.avatarUrl,
        visibility = visibility
    )
