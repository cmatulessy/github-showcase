package com.carlomatulessy.githubshowcase.overview.data.model

import com.carlomatulessy.githubshowcase.overview.domain.model.GithubRepositoryInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubRepositoryInfoResponse(
    @SerialName("name")
    val name: String,
    @SerialName("full_name")
    val fullName: String,
    @SerialName("description")
    val description: String,
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
    val avatarUrl: String,
    @SerialName("html_url")
    val url: String
)

fun GithubRepositoryInfoResponse.toDomain() =
    GithubRepositoryInfo(
        name = name,
        private = private,
        avatarImage = owner.avatarUrl,
        visibility = visibility
    )
