package com.carlomatulessy.githubshowcase.overview.domain.repository

import com.carlomatulessy.githubshowcase.core.data.model.ApiResponse
import com.carlomatulessy.githubshowcase.overview.data.model.GithubRepositoryInfoResponse
import com.carlomatulessy.githubshowcase.overview.domain.model.GithubRepositoryInfo
import kotlinx.coroutines.flow.Flow

interface GitHubRepository  {
    fun getListOfRepositories(): Flow<ApiResponse<List<GithubRepositoryInfo>>>
}