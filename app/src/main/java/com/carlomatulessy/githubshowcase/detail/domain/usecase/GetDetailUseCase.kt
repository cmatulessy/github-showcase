package com.carlomatulessy.githubshowcase.detail.domain.usecase

import com.carlomatulessy.githubshowcase.core.data.model.ApiResponse
import com.carlomatulessy.githubshowcase.overview.domain.model.GithubRepositoryInfo
import com.carlomatulessy.githubshowcase.overview.domain.repository.GitHubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

class GetDetailUseCase(
    private val repository: GitHubRepository
) {
    private fun execute(id: Int): Flow<ApiResponse<GithubRepositoryInfo>> =
        repository.getRepositoryById(id)

    operator fun invoke(id: Int) =
        execute(id)
            .flowOn(Dispatchers.IO)
            .catch { emit(ApiResponse.Failed(it as Exception)) }
}