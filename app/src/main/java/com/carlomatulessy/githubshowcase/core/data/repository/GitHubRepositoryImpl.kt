package com.carlomatulessy.githubshowcase.core.data.repository

import com.carlomatulessy.githubshowcase.core.data.model.ApiResponse
import com.carlomatulessy.githubshowcase.core.data.model.toDomain
import com.carlomatulessy.githubshowcase.core.data.service.GitHubRepositoryApi
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

    private var _cachedListOfRepositories: List<GithubRepositoryInfo>? = null
    override fun getListOfRepositories(): Flow<ApiResponse<List<GithubRepositoryInfo>>> = flow {
        emit(
            _cachedListOfRepositories?.let {
                ApiResponse.Success(it)
            } ?: run {
                gitHubRepositoryApi.getRepositories().run {

                    // TODO improvement: handle this in inline function
                    this.body()?.let { listResponse ->
                        if (isSuccessful) {
                            val list = listResponse.map { it.toDomain() }
                            _cachedListOfRepositories = list
                            ApiResponse.Success(data = list)
                        } else {
                            ApiResponse.Failed(Exception())
                        }
                    }
                } ?: run {
                    ApiResponse.Failed(Exception("Something went wrong in GitHubRepositoryImpl"))
                }
            }
        )
    }.flowOn(Dispatchers.IO)

    override fun getRepositoryById(id: Int?): Flow<ApiResponse<GithubRepositoryInfo>> = flow {
        emit(
            id?.let { safeId ->
                _cachedListOfRepositories?.let { list ->
                    ApiResponse.Success(data = list.filter { it.id == safeId }.first())
                } ?: run {
                    ApiResponse.Failed(Exception("Cache is empty"))
                }
            } ?: run {
                ApiResponse.Failed(Exception("id is empty"))
            }
        )
    }.flowOn(Dispatchers.IO)
}
