package com.carlomatulessy.githubshowcase.overview.data.model

import com.carlomatulessy.githubshowcase.overview.domain.model.GithubRepositoryInfo
import kotlinx.serialization.Serializable

@Serializable
data class GitHubRepositoryResponse(
    val list: List<GithubRepositoryInfoResponse>
)

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

fun GitHubRepositoryResponse.toDomain() =
    list.map {
        GithubRepositoryInfo(
            name = it.name,
            private = it.private,
            avatarImage = it.owner.avatarUrl,
            visibility = it.visibility
        )
    }
