package com.carlomatulessy.githubshowcase.overview.data.model

import com.carlomatulessy.githubshowcase.overview.domain.model.GithubRepository
import kotlinx.serialization.Serializable

@Serializable
data class GithubRepositoryResponse(
    val name: String,
    val private: Boolean,
    val owner: OwnerResponse,
    val visibility: String
)

@Serializable
data class OwnerResponse(
    val avatarUrl: String // TODO double check if this works, original field name is avatar_url
)

fun GithubRepositoryResponse.toDomain() =
    GithubRepository(
        name = name,
        private = private,
        avatarImage = owner.avatarUrl,
        visibility = visibility
    )
