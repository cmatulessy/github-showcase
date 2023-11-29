package com.carlomatulessy.githubshowcase.overview.data.repository

import android.util.Log
import com.carlomatulessy.githubshowcase.core.data.model.ApiResponse
import com.carlomatulessy.githubshowcase.overview.data.model.toDomain
import com.carlomatulessy.githubshowcase.overview.data.service.GitHubRepositoryApi
import com.carlomatulessy.githubshowcase.overview.domain.model.GithubRepositoryInfo
import com.carlomatulessy.githubshowcase.overview.domain.repository.GitHubRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GitHubRepositoryImpl(
    private val gitHubRepositoryApi: GitHubRepositoryApi
) : GitHubRepository {
    override fun getListOfRepositories(): Flow<ApiResponse<List<GithubRepositoryInfo>>> = flow {
        emit(
            when(val response = gitHubRepositoryApi.getRepositories().also { Log.d("TEST", it.toString()) }) {
                is ApiResponse.Failed -> ApiResponse.Failed(response.e)
                is ApiResponse.Success -> ApiResponse.Success(data = response.data.toDomain())
            }
        )
    }.flowOn(Dispatchers.IO)
}