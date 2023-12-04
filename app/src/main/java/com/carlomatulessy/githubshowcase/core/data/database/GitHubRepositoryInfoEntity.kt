package com.carlomatulessy.githubshowcase.core.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GitHubRepositoryInfoEntity(
    @PrimaryKey
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("full_name")
    val fullName: String,
    @ColumnInfo("description")
    val description: String,
    @ColumnInfo("is_private")
    val isPrivate: Boolean,
    @ColumnInfo("owner")
    val owner: OwnerEntity,
    @ColumnInfo("visibility")
    val visibility: String
)

@Entity
data class OwnerEntity(
    @ColumnInfo("avatar_url")
    val avatarUrl: String,
    @ColumnInfo("html_url")
    val htmlUrl: String
)