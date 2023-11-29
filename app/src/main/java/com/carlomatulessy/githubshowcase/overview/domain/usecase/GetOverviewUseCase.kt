package com.carlomatulessy.githubshowcase.overview.domain.usecase

import com.carlomatulessy.githubshowcase.core.data.model.ApiResponse
import com.carlomatulessy.githubshowcase.overview.domain.model.GithubRepositoryInfo
import com.carlomatulessy.githubshowcase.overview.domain.repository.GitHubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

class GetOverviewUseCase(
    private val repository: GitHubRepository
) {

    private fun execute(): Flow<ApiResponse<List<GithubRepositoryInfo>>> =
        repository.getListOfRepositories()

    operator fun invoke() =
        execute()
            .flowOn(Dispatchers.IO)
            .catch { emit(ApiResponse.Failed(it as Exception)) }
}