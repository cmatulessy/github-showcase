package com.carlomatulessy.githubshowcase.core.data.model

import com.carlomatulessy.githubshowcase.overview.domain.model.GithubRepositoryInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubRepositoryInfoResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("full_name")
    val fullName: String,
    @SerialName("description")
    val description: String?,
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
    val htmlUrl: String
)

fun GithubRepositoryInfoResponse.toDomain() =
    GithubRepositoryInfo(
        id = id,
        name = name,
        fullName = fullName,
        description = description,
        isPrivate = private,
        avatarUrl = owner.avatarUrl,
        visibility = visibility,
        htmlUrl = owner.htmlUrl
    )
