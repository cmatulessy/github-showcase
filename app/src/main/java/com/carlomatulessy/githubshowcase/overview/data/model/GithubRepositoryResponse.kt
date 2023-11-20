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

fun GitHubRepositoryResponse.toDomain() {
    val result = list.forEach { response ->
        GithubRepositoryInfo(
            name = response.name,
            private = response.private,
            avatarImage = response.owner.avatarUrl,
            visibility = response.visibility
        )
    }

    // TODO add to new list and return list here
}
