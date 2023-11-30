package com.carlomatulessy.githubshowcase.overview.data.model

import com.carlomatulessy.githubshowcase.overview.domain.model.GithubRepositoryInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubRepositoryInfoResponse(
    @SerialName("name")
    val name: String,
    @SerialName("private")
    val private: Boolean,
    @SerialName("owner")
    val owner: OwnerResponse,
    @SerialName("visibility")
    val visibility: String
)

@Serializable
data class OwnerResponse(
    @SerialName("avatar_url")
    val avatarUrl: String // TODO double check if this works, original field name is avatar_url
)

fun GithubRepositoryInfoResponse.toDomain() =
    GithubRepositoryInfo(
        name = name,
        private = private,
        avatarImage = owner.avatarUrl,
        visibility = visibility
    )
