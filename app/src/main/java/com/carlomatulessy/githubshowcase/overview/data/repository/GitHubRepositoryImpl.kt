package com.carlomatulessy.githubshowcase.overview.data.repository

import com.carlomatulessy.githubshowcase.core.data.model.ApiResponse
import com.carlomatulessy.githubshowcase.overview.data.model.toDomain
import com.carlomatulessy.githubshowcase.overview.data.service.GitHubRepositoryApi
import com.carlomatulessy.githubshowcase.overview.domain.model.GithubRepositoryInfo
import com.carlomatulessy.githubshowcase.overview.domain.repository.GitHubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import java.lang.Exception

class GitHubRepositoryImpl(
    private val gitHubRepositoryApi: GitHubRepositoryApi
) : GitHubRepository {
    override fun getListOfRepositories(): Flow<ApiResponse<List<GithubRepositoryInfo>>> = flow {
        emit(
            gitHubRepositoryApi.getRepositories().run {
                // TODO handle this in different class
                this.body()?.let { listResponse ->
                    if (isSuccessful) {
                        ApiResponse.Success(data = listResponse.map { it.toDomain() })
                    } else {
                        ApiResponse.Failed(Exception())
                    }
                }
            } ?: run {
                ApiResponse.Failed(Exception())
            }
        )
    }.flowOn(Dispatchers.IO)
}
